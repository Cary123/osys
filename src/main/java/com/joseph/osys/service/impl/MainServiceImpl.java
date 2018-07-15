package com.joseph.osys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.joseph.osys.Exception.ParameterException;
import com.joseph.osys.mapper.BookMapper;
import com.joseph.osys.pojos.Book;
import com.joseph.osys.pojos.BookExample;
import com.joseph.osys.service.MainService;
import com.joseph.osys.util.CheckParameter;

public class MainServiceImpl implements MainService{
	@Autowired
	BookMapper bookMapper;
	
	public HashMap<String,Object> queryBookList(String keywords, Integer currentPage, Integer pageSize){
		//ParameterException parameterException = new ParameterException();
		HashMap<String,Object> bookMap = new HashMap<String, Object>();
		List<Book> bookList = new ArrayList<Book>();
		//HashMap<String, String> hashMap = new HashMap<String, String>();
		
		if(CheckParameter.checkParameterNullOrEmpty(pageSize)){
			pageSize = 20;
		}
		if(CheckParameter.checkParameterNullOrEmpty(currentPage)){
			/*
			parameterException.setCode(2001);
			hashMap.put("nullParameter", "currentPage or pageSize is empty");
			parameterException.setMsgField(hashMap);
			throw parameterException;
			*/
			currentPage = 1;
		}
		BookExample example = new BookExample();
		if(!CheckParameter.checkParameterNullOrEmpty(keywords)){
			example.setKeywords(keywords);
		}
		int totalCount = bookMapper.countByExample(example);
		if(totalCount % pageSize == 0){
			totalCount = totalCount / pageSize;
		}else{
			totalCount = totalCount / pageSize + 1;
		}
		example.setLimit(pageSize);
		example.setStart(pageSize*(currentPage-1));
		example.setOrderByClause("bookId asc");
		bookList = (ArrayList<Book>) bookMapper.selectByExample(example);
		bookMap.put("totalCount", totalCount);
		bookMap.put("bookList", bookList);
		System.out.println(totalCount + "|" + bookList.size());
		return bookMap;
	}
}
