package com.joseph.osys.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseph.osys.Exception.LoginParameterException;
import com.joseph.osys.common.CodeType;
import com.joseph.osys.mapper.UserMapper;
import com.joseph.osys.pojos.User;
import com.joseph.osys.service.LoginService;
import com.joseph.osys.util.CheckParameter;
import com.joseph.osys.util.EncryptUtils;
import com.joseph.osys.util.StringUtils;

@Service("LoginService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private UserMapper userMapper;
	
	public User login(String randomNum, String userName, String password) throws LoginParameterException, Exception{
		User currentUser = null;
		LoginParameterException loginException = new LoginParameterException();
		if(CheckParameter.checkParameterNullOrEmpty(userName))
		{
			loginException.setCode(CodeType.LOGIN_PARAMETER_ERROR);
			loginException.getMsgField().put("fillUserName", "用户名需要填写");
		}
		if(CheckParameter.checkParameterNullOrEmpty(password))
		{
			loginException.setCode(CodeType.LOGIN_PARAMETER_ERROR);
			loginException.getMsgField().put("fillPassword", "密码需要填写");
		}
		if(loginException.getMsgField().size() > 0)
		{
			throw loginException;
		}
		else
		{
			currentUser = userMapper.selectByPrimaryKey(userName);
			if(currentUser == null)
			{
				loginException.setCode(CodeType.LOGIN_FAILED);
				loginException.getMsgField().put("userNameNotExist", "用户名不存在");
				throw loginException;
			}
			else 
			{				
				if(EncryptUtils.saltHash(password, currentUser.getHashSalt()).equalsIgnoreCase(currentUser.getPassword()))
				{
					currentUser.setPassword(null);
					return currentUser;					
				}
				else
				{
					loginException.setCode(CodeType.LOGIN_FAILED);
					loginException.getMsgField().put("passwordWrong", "密码错误");
					throw loginException;
				}
			}
		
		}
	}
}
