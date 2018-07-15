package com.joseph.osys.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joseph.osys.Exception.ParameterException;
import com.joseph.osys.common.CodeType;
import com.joseph.osys.common.ResultReturn;
import com.joseph.osys.mapper.BookMapper;
import com.joseph.osys.mapper.ChapterMapper;
import com.joseph.osys.mapper.UserMapper;
import com.joseph.osys.mapper.VideonoteMapper;
import com.joseph.osys.model.BookDetail;
import com.joseph.osys.model.BookNoteUser;
import com.joseph.osys.model.BookVideo;
import com.joseph.osys.model.VideoNoteUser;
import com.joseph.osys.pojos.Book;
import com.joseph.osys.pojos.Booknote;
import com.joseph.osys.pojos.BooknoteExample;
import com.joseph.osys.pojos.Chapter;
import com.joseph.osys.pojos.ChapterExample;
import com.joseph.osys.pojos.User;
import com.joseph.osys.pojos.Videonote;
import com.joseph.osys.pojos.VideonoteExample;
import com.joseph.osys.pojos.ChapterExample.Criteria;
import com.joseph.osys.service.MainService;

@Controller
@RequestMapping("/main")
public class VideoController {
	@Autowired
	private ChapterMapper chapterMapper;
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private VideonoteMapper videonoteMapper;
	
	@RequestMapping(value = "/video", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String video(Model model){
		HashMap<String, Object> bookMap;
		List<BookVideo> bookVideoList = null;
		try {
			bookMap = mainService.queryBookList(null, 1, 20);
			model.addAttribute("totalCount", bookMap.get("totalCount"));
			List<Book> bookList = (List<Book>) bookMap.get("bookList");
			bookVideoList = new ArrayList<BookVideo>();
			for (int i = 0; i<bookList.size(); i++) {
				if(bookList.get(i)!=null)
				{
					Chapter chapter= chapterMapper.selectByBookAndId(bookList.get(i).getBookid(), 1);
					BookVideo bookVideo = new BookVideo();
					bookVideo.setBook(bookList.get(i));
					if(chapter != null){
						bookVideo.setChapter(chapter);
					}
					bookVideoList.add(bookVideo);
				}
			}
		} catch (ParameterException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("videoList", bookVideoList);
		model.addAttribute("currentPage", 1);
		model.addAttribute("keywords", null);
		return "main/video/videoIndex";
	}
	
	@RequestMapping(value = "/videoShow", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String videoShow(Model model,Integer chapterId, Integer bookId){
		try {
			Chapter chapter = chapterMapper.selectByPrimaryKey(chapterId);
			ChapterExample chapterExample = new ChapterExample();
			Criteria criteria = chapterExample.createCriteria();
			chapterExample.setOrderByClause("chapternameid asc");
			criteria.andBookidEqualTo(bookId);
			List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
			Book book = bookMapper.selectByPrimaryKey(bookId);
			
			VideonoteExample example = new VideonoteExample();
			example.setOrderByClause("noteid desc");
			com.joseph.osys.pojos.VideonoteExample.Criteria criterai = example.createCriteria();
			criterai.andChapteridEqualTo(chapterId);
			List<Videonote> videonotes = videonoteMapper.selectByExampleWithBLOBs(example);
			List<VideoNoteUser> vUsers = new ArrayList<VideoNoteUser>();
			for (Videonote videonote : videonotes) {
				VideoNoteUser vUser = new VideoNoteUser();
				if(videonote != null && videonote.getCreater() != null)
				{
					vUser.setVideonote(videonote);
					vUser.setUser(userMapper.selectByPrimaryKey(videonote.getCreater()));
					vUsers.add(vUser);
				}
			}
			
			model.addAttribute("chapter", chapter);
			model.addAttribute("book", book);
			model.addAttribute("chapterList", chapterList);
			model.addAttribute("videoNoteList", vUsers);
			model.addAttribute("count", vUsers.size());
		} catch (Exception e) {
			model.addAttribute("error", "视频资源不存在");
		}
		return "main/video/video_show";
	}
	

	@RequestMapping(value = "/publishVideoNote")
	public @ResponseBody ResultReturn publishVideoNote(Model model, Integer chapterId, String editorValue, HttpSession session) {
		ResultReturn data = new ResultReturn();
		try {
			String content = editorValue;
			Videonote videonote = new Videonote();
			User user = (User) session.getAttribute("currentUser");
			user.setPassword(null);
			videonote.setCreater(user.getUsername());
			videonote.setNotecontent(content);
			videonote.setNotetime(new Date());
			videonote.setChapterid(chapterId);
			videonoteMapper.insert(videonote);
			data.setReturnCode(CodeType.SUCCESS);
			data.setMapField("videoNote", videonote);
			data.setMapField("user", user);
		} catch (Exception e) {
			data.setReturnCode(CodeType.FAILURE);
		}
		return data;
	}
	
	@RequestMapping(value = "/listVideoShow", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody ResultReturn listVideoShow(Model model,String keywords,Integer currentPage){
		ResultReturn data = new ResultReturn();
		HashMap<String, Object> bookMap;
		try {
			bookMap = mainService.queryBookList(keywords, currentPage, 20);
			data.setReturnCode(CodeType.SUCCESS);
			data.setfield(bookMap);
		} catch (ParameterException e) {
			data.setReturnCode(CodeType.FAILURE);
			data.setMapField("error",e.getMsgField());
		} catch (Exception e) {
			data.setReturnCode(CodeType.FAILURE);
		}
		return data;
	}
	
	@RequestMapping(value = "/listVideoShowV2", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String listVideoShowV2(Model model,String keywords,Integer currentPage){
		HashMap<String, Object> bookMap;
		try {
			bookMap = mainService.queryBookList(keywords, currentPage, 20);
			model.addAttribute("totalCount", bookMap.get("totalCount"));
			List<Book> bookList = (List<Book>) bookMap.get("bookList");
			List<BookVideo> bookVideoList = new ArrayList<BookVideo>();
			for (int i = 0; i<bookList.size(); i++) {
				Chapter chapter= chapterMapper.selectByBookAndId(bookList.get(i).getBookid(), 1);
				BookVideo bookVideo = new BookVideo();
				bookVideo.setBook(bookList.get(i));
				if(chapter != null){
					bookVideo.setChapter(chapter);
				}
				bookVideoList.add(bookVideo);
			}
			model.addAttribute("videoList", bookVideoList);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("keywords", keywords);
		} catch (ParameterException e) {
			
		} catch (Exception e) {
			
		}
		return "main/video/videoIndex";
	}
	
	@RequestMapping(value = "/listVideoShowV3", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String listVideoShowV3(Model model,String keywords,Integer currentPage){
		HashMap<String, Object> bookMap;
		try {
			bookMap = mainService.queryBookList(keywords, 1, 20);
			model.addAttribute("totalCount", bookMap.get("totalCount"));
			List<Book> bookList = (List<Book>) bookMap.get("bookList");
			List<BookVideo> bookVideoList = new ArrayList<BookVideo>();
			for (int i = 0; i<bookList.size(); i++) {
				Chapter chapter= chapterMapper.selectByBookAndId(bookList.get(i).getBookid(), 1);
				BookVideo bookVideo = new BookVideo();
				bookVideo.setBook(bookList.get(i));
				if(chapter != null){
					bookVideo.setChapter(chapter);
				}
				bookVideoList.add(bookVideo);
			}
			model.addAttribute("videoList", bookVideoList);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("keywords", keywords);
		} catch (ParameterException e) {
			
		} catch (Exception e) {
			
		}
		return "main/video/videoIndex";
	}
	
	@RequestMapping(value = "/showVideoDetail", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String showBookDetai(Model model,Integer id){
		try {
			//BookDetail bookDetail = bookService.getBookDetail(id);
			//model.addAttribute("bookDetail", bookDetail);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "main/video/video_show";
	}

}
