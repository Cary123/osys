package com.joseph.osys.service;
import com.joseph.osys.Exception.LoginParameterException;
import com.joseph.osys.pojos.User;

public interface RegistService {
	public int regist(User user) throws LoginParameterException, Exception;
}
