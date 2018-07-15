package com.joseph.osys.service;
import java.util.HashMap;

import com.joseph.osys.Exception.ParameterException;
public interface MainService {
	public HashMap<String,Object> queryBookList(String keywords, Integer currentPage, Integer pageSize) throws ParameterException, Exception;
}
