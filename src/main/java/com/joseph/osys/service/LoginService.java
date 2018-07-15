package com.joseph.osys.service;

import com.joseph.osys.Exception.LoginParameterException;
import com.joseph.osys.pojos.User;

public interface LoginService {
	public User login(String randomNum, String userName, String password) throws LoginParameterException, Exception; 
}
