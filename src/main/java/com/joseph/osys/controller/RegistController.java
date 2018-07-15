package com.joseph.osys.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joseph.osys.common.CodeType;
import com.joseph.osys.common.HardString;
import com.joseph.osys.common.ResultReturn;
import com.joseph.osys.common.RoleType;
import com.joseph.osys.common.ThreadCleanTask;
import com.joseph.osys.mail.MailUtilSend;
import com.joseph.osys.mapper.UserMapper;
import com.joseph.osys.pojos.User;
import com.joseph.osys.service.RegistService;
import com.joseph.osys.util.CheckParameter;
import com.joseph.osys.util.EncryptUtils;
import com.joseph.osys.util.StringUtils;
import com.joseph.osys.util.UtilsHelper;
@Controller
public class RegistController {
	@Autowired
	private RegistService registService;

	@Autowired
	private UserMapper userMapper;
	
	// 注册
	@RequestMapping("/registSubmit")
	public @ResponseBody ResultReturn regist(HttpSession session, HttpServletRequest request) throws Exception {
		ResultReturn data = new ResultReturn();
		data.setReturnCode(CodeType.SUCCESS);
		// 调用service进行用户身份验证
		User newUser = null;
		// 调用service
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		String userSex = request.getParameter("userSex");
		String age = request.getParameter("userAge");
		Integer userAge = Integer.parseInt((age != null) ? age : "20"); 
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		String userCode = request.getParameter("userCode");
		/*
		String currentCode = (String) session.getAttribute("userCode");
		if(CheckParameter.checkParameterNullOrEmpty(userCode) || (!userCode.trim().equals(currentCode))){
			data.setCodeAndContent(CodeType.FAILURE, "codeError", "验证码错误");
		}
		*/
		if(CheckParameter.checkParameterNullOrEmpty(userName) || (!UtilsHelper.isUserNameRight(userName))){
			data.setCodeAndContent(CodeType.FAILURE, "userNameError", "用户名不合法");
		}else{
			User user = userMapper.selectByPrimaryKey(userName);
			if(user != null)
			{
				data.setCodeAndContent(CodeType.FAILURE, "nameRegisted", "用户名已经被注册！");
			}
		}
		if(CheckParameter.checkParameterNullOrEmpty(password, rePassword) || (!password.trim().equals(rePassword.trim()))){
			data.setCodeAndContent(CodeType.FAILURE, "passwordError", "密码不合法");
		}
		if(data.getReturnCode() != CodeType.FAILURE){
			newUser = new User();
			newUser.setUsername(userName);			
			if(userSex.equals("man")){
				newUser.setSex("男");
			}else if(userSex.equals("woman")){
				newUser.setSex("女");
			}else{
				newUser.setSex("男");
			}
			newUser.setAge(userAge);
			newUser.setPhone(userPhone);
			newUser.setEmail(userEmail);
			newUser.setRoleid(RoleType.ORDINARY_USERS_ID);
			newUser.setPhoto(HardString.defaultPhoto);
			newUser.setHashSalt(StringUtils.getRandomNum(10));
			newUser.setPassword(EncryptUtils.saltHash(password, newUser.getHashSalt()));
			registService.regist(newUser);
			data.setCodeAndContent(CodeType.SUCCESS, "result", "注册成功！");
		}
		return data;
	}
	
	// 注册
	@RequestMapping("/regist")
	public String registNew(HttpSession session) throws Exception {
		return "regist";
	}
	
	@RequestMapping("/getCode")
	//@RequestBody 将json串转换成Java对象
	//@ResponseBody 将Java对象转换成Json串
	public @ResponseBody ResultReturn getCode(HttpSession session, String email, String userName) throws Exception {
		ResultReturn data = new ResultReturn();
		if(session.getAttribute("userCode") == null){
			if(userName != null){
				User user = userMapper.selectByPrimaryKey(userName);
				if(user != null){
					email = user.getEmail();
				}
			}
			String receiveEmail = email;
	        String receiveNick = "Dear:";
	        String subject = "The follow may help you:";
	        String code = UtilsHelper.getRandNum(1, 999999)+"";
	        String msg = HardString.msgBefore + code + HardString.msgAfter + new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
	        boolean b = MailUtilSend.sendMail(receiveEmail, receiveNick, subject, msg);
	        if(b){
	        	session.setAttribute("userCode", code);
	        	new Thread(new ThreadCleanTask(session, "userCode", 60)).start();
	        	data.setReturnCode(CodeType.SUCCESS);
	        }else{
	        	new Thread(new ThreadCleanTask(session, "userCode", 60)).start();
	        	data.setReturnCode(CodeType.FAILURE);
				data.setMapField("result", "邮箱不存在！");
	        }
			}
		else
			{
				data.setReturnCode(CodeType.FAILURE);
				data.setMapField("result", "服务器访问过于频繁，请60秒后重试");
			}
        return data;
	}
}
