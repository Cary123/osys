package com.joseph.osys.service;

import java.util.HashMap;

import com.joseph.osys.Exception.ParameterException;

public interface VideoService {
	public HashMap<String,Object> queryVideoList(String keywords, Integer currentPage, Integer pageSize) throws ParameterException, Exception;
}
