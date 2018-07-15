package com.joseph.osys.controller;
import org.apache.log4j.Logger;

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
import com.joseph.osys.mapper.BooknoteMapper;
import com.joseph.osys.mapper.UserMapper;
import com.joseph.osys.model.BookDetail;
import com.joseph.osys.model.BookNoteUser;
import com.joseph.osys.pojos.Booknote;
import com.joseph.osys.pojos.BooknoteExample;
import com.joseph.osys.pojos.User;
import com.joseph.osys.pojos.BooknoteExample.Criteria;
import com.joseph.osys.service.BookService;
import com.joseph.osys.service.MainService;

@Controller
@RequestMapping("/main")
public class MainController {
	private static final Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	BooknoteMapper booknoteMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping(value = "/listBookShow", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody ResultReturn listRequest(Model model,String keywords,Integer currentPage){
		ResultReturn data = new ResultReturn();
		HashMap<String, Object> bookMap;
		try {
			bookMap = mainService.queryBookList(keywords, currentPage, 20);
			data.setReturnCode(CodeType.SUCCESS);
			data.setfield(bookMap);
		} catch (ParameterException e) {
			data.setReturnCode(CodeType.FAILURE);
			data.setMapField("error",e.getMsgField());
			logger.error(e.getMessage());
		} catch (Exception e) {
			data.setReturnCode(CodeType.FAILURE);
			logger.error(e.getMessage());
		}
		return data;
	}
	
	@RequestMapping(value = "/listBookShowV2", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String listRequestV2(Model model,String keywords,Integer currentPage){
		HashMap<String, Object> bookMap;
		try {
			bookMap = mainService.queryBookList(keywords, currentPage, 20);
			model.addAttribute("totalCount", bookMap.get("totalCount"));
			model.addAttribute("bookList", bookMap.get("bookList"));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("keywords", keywords);
		} catch (ParameterException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "main/index";
	}
	
	@RequestMapping(value = "/listBookShowV3", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String listRequestV3(Model model,String keywords,Integer currentPage){
		HashMap<String, Object> bookMap;
		try {
			bookMap = mainService.queryBookList(keywords, 1, 20);
			model.addAttribute("totalCount", bookMap.get("totalCount"));
			model.addAttribute("bookList", bookMap.get("bookList"));
			model.addAttribute("currentPage", 1);
			model.addAttribute("keywords", keywords);
		} catch (ParameterException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "main/index";
	}
	
	@RequestMapping(value = "/showBookDetail", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String showBookDetai(Model model,Integer id){
		try {
			BookDetail bookDetail = bookService.getBookDetail(id);
			BooknoteExample example = new BooknoteExample();
			example.setOrderByClause("noteid desc");
			Criteria criterai = example.createCriteria();
			criterai.andBookidEqualTo(id);
			List<Booknote> booknotes = booknoteMapper.selectByExampleWithBLOBs(example);
			List<BookNoteUser> bUsers = new ArrayList<BookNoteUser>();
			for (Booknote booknote : booknotes) {
				BookNoteUser bUser = new BookNoteUser();
				if(booknote != null && booknote.getCreater() != null)
				{
					bUser.setBooknote(booknote);
					bUser.setUser(userMapper.selectByPrimaryKey(booknote.getCreater()));
					bUsers.add(bUser);
				}
			}
			model.addAttribute("bookDetail", bookDetail);
			model.addAttribute("bookNoteList", bUsers);
			model.addAttribute("count", bUsers.size());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
		}
		return "main/book/book_show";
	}
	
	
	
	@RequestMapping(value = "/publishBookNote")
	public @ResponseBody ResultReturn publishBookNote(Model model, Integer bookId, String editorValue, HttpSession session) {
		ResultReturn data = new ResultReturn();
		try {
			String content = editorValue;
			Booknote bookNote = new Booknote();
			User user = (User) session.getAttribute("currentUser");
			user.setPassword(null);
			bookNote.setCreater(user.getUsername());
			bookNote.setNotecontent(content);
			bookNote.setNotetime(new Date());
			bookNote.setBookid(bookId);
			booknoteMapper.insert(bookNote);
			data.setReturnCode(CodeType.SUCCESS);
			data.setMapField("bookNote", bookNote);
			data.setMapField("user", user);
		} catch (Exception e) {
			data.setReturnCode(CodeType.FAILURE);
		}
		return data;
	}
	
}
