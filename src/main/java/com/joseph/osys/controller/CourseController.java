package com.joseph.osys.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.joseph.osys.Exception.ParameterException;
import com.joseph.osys.common.CodeType;
import com.joseph.osys.common.ResultReturn;
import com.joseph.osys.mapper.BookMapper;
import com.joseph.osys.pojos.Book;
import com.joseph.osys.service.CourseService;
import com.joseph.osys.service.LoginService;
import com.joseph.osys.service.MainService;
import com.joseph.osys.util.CheckParameter;

@Controller
public class CourseController {
	// @RequestParam里边指定request传入参数名称和形参进行绑定。
	// 通过required属性指定参数是否必须要传入
	// 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping(value = "/addCourseShow")
	public String addCourseShow() throws Exception {
		return "admin/addCourse";
	}

	@RequestMapping(value = "/deleteCourseShow")
	public String deleteCourseShow(Model model, String keywords, Integer currentPage) throws Exception {
		HashMap<String, Object> bookMap;
		try {
			bookMap = mainService.queryBookList(keywords, currentPage, 20);
			model.addAttribute("totalCount", bookMap.get("totalCount"));
			model.addAttribute("books", bookMap.get("bookList"));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("keywords", keywords);
		} catch (ParameterException e) {
		} catch (Exception e) {
		}
		return "admin/deleteCourse";
	}

	@RequestMapping(value = "/editCourseShow")
	public String editCourseShow(Model model, String keywords, Integer currentPage) throws Exception {
		HashMap<String, Object> bookMap;
		if(currentPage == null){
			currentPage = 1;
		}
		try {
			bookMap = mainService.queryBookList(keywords, currentPage, 20);
			model.addAttribute("totalCount", bookMap.get("totalCount"));
			model.addAttribute("books", bookMap.get("bookList"));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("keywords", keywords);
		} catch (ParameterException e) {
		} catch (Exception e) {
		}
		return "admin/editCourse";
	}

	@RequestMapping(value = "/listCourseShow")
	public String listCourseShow(Model model, String keywords, Integer currentPage) throws Exception {
		HashMap<String, Object> bookMap;
		if(currentPage == null){
			currentPage = 1;
		}
		try {
			bookMap = mainService.queryBookList(keywords, currentPage, 20);
			model.addAttribute("totalCount", bookMap.get("totalCount"));
			model.addAttribute("books", bookMap.get("bookList"));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("keywords", keywords);
		} catch (ParameterException e) {
		} catch (Exception e) {
		}
		return "admin/listCourse";
	}
	
	@RequestMapping(value = "/deleteCourse")
	public @ResponseBody String deleteCourse(int id)
	{
	   int i = bookMapper.deleteByPrimaryKey(id);
	   if(i!=0){
	     return "success";
	   }else{
	     return "fail";
	   }
	}
	
	@RequestMapping(value = "/showEditCourse")
    public String showEditCourse(Model model,int id){
	   Book book;
	   book = bookMapper.selectByPrimaryKey(id);
	   model.addAttribute("book", book);
	   return "admin/showEditCourse";
	}
	
	@RequestMapping(value = "/editCourse")
	  public @ResponseBody ResultReturn editCourse(
				@RequestParam(value = "file", required = false) MultipartFile file,
				String courseId,String courseName, String courseDescribe, String courseCreator,
				HttpServletRequest request){
		    ResultReturn data = new ResultReturn();
		    Book book = new Book();
		    book.setBookname(courseName);
			book.setBookdescript(courseDescribe);
			book.setBookcreater(courseCreator);
			book.setBookid(Integer.parseInt(courseId));
			if(!CheckParameter.checkParameterNullOrEmpty(file) && !CheckParameter.checkParameterNullOrEmpty(file.getOriginalFilename()))
			{
				String fileName = file.getOriginalFilename(); // 获取文件名
			    String parentPath = request.getSession().getServletContext().getRealPath("/");
			    String path = parentPath+"static/picture";
				fileName = new Date().getTime()+""+new Random().nextInt(10000)+"_"+fileName.substring(fileName.lastIndexOf('.'));
				File targetFile = new File(path, fileName);
				if(!targetFile.exists()){ 
					try {
						byte[] buf = file.getBytes();// 文件二进制
						OutputStream os = new FileOutputStream(targetFile);
						os.write(buf);
						os.flush();
						os.close();
						book.setBookimage("static/picture/"+fileName);
					} catch (IOException e) {
						data.setReturnCode(CodeType.FAILURE);
						e.printStackTrace();
					}	
				}
			}
			int i = bookMapper.updateByPrimaryKeySelective(book);
			if(i!=0){
				data.setReturnCode(CodeType.SUCCESS);
			}else{
				data.setReturnCode(CodeType.FAILURE);
			}
			return data;
		}
	/**
	 * @param file
	 * @param courseName
	 * @param courseDescribe
	 * @param courseCreator
	 * @param request
	 * @return
	 */
	//Add the course into database.
	@RequestMapping(value = "/uploadFile")
	public @ResponseBody ResultReturn uploadFile(
			@RequestParam(value = "file", required = false) MultipartFile file,
			String courseName, String courseDescribe, String courseCreator,
			HttpServletRequest request) {
		ResultReturn data = new ResultReturn();
	    Book book = new Book();
	    book.setBookname(courseName);
		book.setBookdescript(courseDescribe);
		book.setBookcreater(courseCreator);
		if(!CheckParameter.checkParameterNullOrEmpty(file) && !CheckParameter.checkParameterNullOrEmpty(file.getOriginalFilename()))
		{
		    String fileName = file.getOriginalFilename(); // 获取文件名
			String parentPath = request.getSession().getServletContext().getRealPath("/");
			fileName = new Date().getTime()+""+new Random().nextInt(10000)+"_"+fileName.substring(fileName.lastIndexOf('.'));
			String path = parentPath+"static/picture"; 
			File targetFile = new File(path, fileName);
			if(!targetFile.exists()){ 
				
				try {
					byte[] buf = file.getBytes();// 文件二进制
					OutputStream os = new FileOutputStream(targetFile);
					os.write(buf);
					os.flush();
					os.close();
					book.setBookimage("static/picture/"+fileName);
				} catch (IOException e) {
					e.printStackTrace();
				}		
			}
		}
		if(courseService.addCourse(book) == 0)
		{
			data.setReturnCode(CodeType.FAILURE);
		}else
		{
			data.setReturnCode(CodeType.SUCCESS);
		}
		return data;
	}
}
