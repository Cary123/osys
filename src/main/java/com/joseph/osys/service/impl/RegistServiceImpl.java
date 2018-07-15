package com.joseph.osys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseph.osys.Exception.LoginParameterException;
import com.joseph.osys.mapper.UserMapper;
import com.joseph.osys.pojos.User;
import com.joseph.osys.service.RegistService;

@Service("RegistService")
public class RegistServiceImpl implements RegistService{
	@Autowired
	private UserMapper userMapper;
	
	public int regist(User user) throws LoginParameterException, Exception {
		return userMapper.insert(user);
	}
}
