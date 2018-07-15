package com.joseph.osys.service;

import java.util.HashMap;

import com.joseph.osys.Exception.ParameterException;

public interface DiscussService {
	public HashMap<String,Object> queryQuestionList(String keywords, Integer currentPage, Integer pageSize) throws ParameterException, Exception;
}
