package com.joseph.osys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseph.osys.mapper.BookMapper;
import com.joseph.osys.pojos.Book;
import com.joseph.osys.pojos.BookExample;
import com.joseph.osys.service.CourseService;

@Service("CourseService")
public class CourseServiceImpl implements CourseService{
	@Autowired
	private BookMapper bookMapper;

	public int addCourse(Book course) {
		return bookMapper.insert(course);
	}
	public List<Book> listCourse(){
		BookExample example = new BookExample();
		List<Book> books = bookMapper.selectByExample(example);
		return books;
	}
}
