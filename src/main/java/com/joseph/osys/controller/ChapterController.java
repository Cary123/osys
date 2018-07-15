package com.joseph.osys.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.joseph.osys.common.CodeType;
import com.joseph.osys.common.ResultReturn;
import com.joseph.osys.mapper.BookMapper;
import com.joseph.osys.mapper.ChapterMapper;
import com.joseph.osys.pojos.Book;
import com.joseph.osys.pojos.Chapter;
import com.joseph.osys.pojos.ChapterExample;
import com.joseph.osys.pojos.ChapterExample.Criteria;
import com.joseph.osys.service.CourseService;

@Controller
public class ChapterController {
	
	@Autowired
	private ChapterMapper chapterMapper;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/addChapterShow")
	public String addChapterShow() throws Exception {
		return "admin/addChapter";
	}
	
	@RequestMapping(value = "/deleteChapterShow")
	public String deleteChapterShow(Model model) throws Exception {
		List<Chapter> chapters = chapterMapper.selectByExample(null);
		model.addAttribute("chapters", chapters);
		return "admin/deleteChapter";
	}
	
	@RequestMapping(value = "/editChapterShow")
	public String editChapterShow(Model model) throws Exception {
		List<Chapter> chapters = chapterMapper.selectByExample(null);
		model.addAttribute("chapters", chapters);
		return "admin/editChapter";
	}
	
	@RequestMapping(value = "/listChapterShow")
	public String listChapterShow(Model model) throws Exception {
		List<Chapter> chapters = chapterMapper.selectByExample(null);
		model.addAttribute("chapters", chapters);
		return "admin/listChapter";
	}
	
	@RequestMapping(value = "/getCourseIds")
	public @ResponseBody ResultReturn GetCourseIds() throws Exception {
		ResultReturn data = new ResultReturn();
		data.setReturnCode(0);
		List<Book> books = courseService.listCourse();
		data.setReturnCode(1);
		data.setMapField("books", books);
		return data;
	}
	
	@RequestMapping(value = "/showEditChapter")
	public String showEditChapter(Model model,Integer id){
		 Chapter chapter = chapterMapper.selectByPrimaryKey(id);
		 model.addAttribute("chapter", chapter);
		 return "admin/showEditChapter";
	}
	
	@RequestMapping(value = "/deleteChapter")
	public @ResponseBody String DeleteChapter(int id){
		  int i = chapterMapper.deleteByPrimaryKey(id);
		   if(i!=0){
		     return "success";
		   }else{
		     return "fail";
		   }
	}
	
	@RequestMapping(value = "/addChapter")
	public @ResponseBody ResultReturn addChapter(
			@RequestParam(value = "file", required = false) MultipartFile file,
			String chapterNameId, String chapterName, String bookId ,
			HttpServletRequest request) {
		ResultReturn data = new ResultReturn();
		Chapter chapter = new Chapter();
		chapter.setBookid(Integer.parseInt(bookId));
	    chapter.setChapternameid(Integer.parseInt(chapterNameId));
	    chapter.setChaptername(chapterName);
	    data.setReturnCode(CodeType.SUCCESS);
		if (!file.isEmpty()) {
			String name = file.getOriginalFilename(); // 获取文件名
			String parentPath = request.getSession().getServletContext().getRealPath("/");
			String path = parentPath+"static/video"; 
			String fileName = new Date().getTime()+""+new Random().nextInt(10000)+"_"+name.substring(name.lastIndexOf('.'));
			File targetFile = new File(path, fileName);
			String databaseStorePath = "static/video"+ "/" + fileName;
		    if(!targetFile.exists()){  
				try {
					byte[] buf = file.getBytes();// 文件二进制
					OutputStream os = new FileOutputStream(targetFile);
					os.write(buf);
					os.flush();
					os.close();
					chapter.setVideourl(databaseStorePath);
					data.setReturnCode(CodeType.SUCCESS);
				} catch (IOException e) {
					data.setReturnCode(CodeType.FAILURE);
					e.printStackTrace();
				}
		    }
		}
		chapterMapper.insert(chapter);
		return data;
	}
	
	@RequestMapping(value = "/editChapter")
	public @ResponseBody ResultReturn editChapter(
			@RequestParam(value = "file", required = false) MultipartFile file,
			Integer chapterNameId, String chapterName, Integer chapterId ,
			HttpServletRequest request) {
		ResultReturn data = new ResultReturn();
		data.setReturnCode(CodeType.FAILURE);
		if(chapterId != null){
			Chapter chapter = chapterMapper.selectByPrimaryKey(chapterId);
			chapter.setChapternameid(chapterNameId);
			chapter.setChaptername(chapterName);
		    data.setReturnCode(CodeType.SUCCESS);
			if (!file.isEmpty()) {
				String name = file.getOriginalFilename(); // 获取文件名
				String parentPath = request.getSession().getServletContext().getRealPath("/");
				String path = parentPath+"static/video"; 
				String fileName = new Date().getTime()+""+new Random().nextInt(10000)+"_"+name.substring(name.lastIndexOf('.'));
				File targetFile = new File(path, fileName);
				String databaseStorePath = "static/video"+ "/" + fileName;
			    chapter.setVideourl(databaseStorePath);
			    if(!targetFile.exists()){  
					try {
						byte[] buf = file.getBytes();// 文件二进制
						OutputStream os = new FileOutputStream(targetFile);
						os.write(buf);
						os.flush();
						os.close();
						data.setReturnCode(CodeType.SUCCESS);
					} catch (IOException e) {
						data.setReturnCode(CodeType.FAILURE);
						e.printStackTrace();
					}
			    }
			}
			chapterMapper.updateByPrimaryKeySelective(chapter);
		}
		return data;
	}
	
	@RequestMapping(value = "/showExistChapterList")
	public @ResponseBody ResultReturn showExistChapterList(Integer bookId){
			ResultReturn data= new ResultReturn();
			data.setReturnCode(0);
			if(bookId != null){
				ChapterExample example = new ChapterExample();
				Criteria chapterCriteria = example.createCriteria();
				example.setOrderByClause("chapternameid asc");
				chapterCriteria.andBookidEqualTo(bookId);
				List<Chapter> chapters = chapterMapper.selectByExample(example);
				data.setReturnCode(1);
				data.setMapField("chapters", chapters);
			}
			return data;
	}
	
	@RequestMapping(value = "/showDeleteList")
	public @ResponseBody ResultReturn showDeleteList(Integer bookId){
		ResultReturn data= new ResultReturn();
		data.setReturnCode(0);
		if(bookId != null){
			ChapterExample example = new ChapterExample();
			Criteria chapterCriteria = example.createCriteria();
			example.setOrderByClause("chapternameid asc");
			chapterCriteria.andBookidEqualTo(bookId);
			List<Chapter> chapters = chapterMapper.selectByExample(example);
			data.setReturnCode(1);
			data.setMapField("chapters", chapters);
		}
		return data;
	}
}
