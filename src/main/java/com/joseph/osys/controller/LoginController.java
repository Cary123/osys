package com.joseph.osys.controller;

import java.util.HashMap;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.joseph.osys.Exception.LoginParameterException;
import com.joseph.osys.common.CodeType;
import com.joseph.osys.common.ResultReturn;
import com.joseph.osys.common.RoleType;
import com.joseph.osys.mapper.RoleMapper;
import com.joseph.osys.mapper.UserMapper;
import com.joseph.osys.pojos.Role;
import com.joseph.osys.pojos.User;
import com.joseph.osys.service.LoginService;
import com.joseph.osys.service.MainService;
import com.joseph.osys.util.CheckParameter;
import com.joseph.osys.util.StringUtils;

@Controller
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private MainService mainService;

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private UserMapper userMapper;

	// 登陆
	@RequestMapping("/login")
	public @ResponseBody ResultReturn login(Model model, HttpSession session, String username,
			String password) throws Exception {
		ResultReturn data = new ResultReturn();
		data.setReturnCode(CodeType.FAILURE);
		String randomNum = (String) session.getAttribute("md5RandomKey");
		if (session.getAttribute("currentUser") == null) {
			if(!CheckParameter.checkParameterNullOrEmpty(randomNum))
			{
				// 调用service进行用户身份验证
				User currentUser = null;			
				// 调用service
				try {				
					currentUser = loginService.login(randomNum, username, password);
					currentUser.setPassword(null);
					session.setAttribute("currentUser", currentUser);
					Role role = roleMapper.selectByPrimaryKey(currentUser.getRoleid());
					if (role != null) {
						data.setReturnCode(CodeType.SUCCESS);
						session.setAttribute("role", role.getRolename());
					}
				} catch (LoginParameterException ex) {
					logger.error(ex);
					data.setReturnCode(CodeType.FAILURE);
					data.setMapField("result", ex.getMsgField());
				} catch (Exception e) {
					logger.error(e);
					data.setReturnCode(CodeType.FAILURE);
				}
			}
		} 
		else {
			data.setReturnCode(CodeType.SUCCESS);
		}
		return data;
	}

	@RequestMapping(value = "/index")
	// @RequestParam里边指定request传入参数名称和形参进行绑定。
	// 通过required属性指定参数是否必须要传入
	// 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String returnLogin(HttpSession session, Model model) throws Exception {
		String roleType = (String) session.getAttribute("role");
		if(session.getAttribute("role") != null){	
			if (RoleType.ADMIN.equals(roleType)) {
				return "admin/index";
			}else if(RoleType.ADVANCED_USERS.equals(roleType)){
				HashMap<String, Object> bookMap = mainService.queryBookList(null, 1, 20);
				model.addAttribute("totalCount", bookMap.get("totalCount"));
				model.addAttribute("bookList", bookMap.get("bookList"));
				model.addAttribute("currentPage", 1);
				return "main/index";
			}else if(RoleType.ORDINARY_USERS.equals(roleType)){
				HashMap<String, Object> bookMap = mainService.queryBookList(null, 1, 20);
				model.addAttribute("totalCount", bookMap.get("totalCount"));
				model.addAttribute("bookList", bookMap.get("bookList"));
				model.addAttribute("currentPage", 1);
				return "main/index";
			}
			else
			{	
				
				return "login";
			}
		}
		else
		{	
			session.setAttribute("md5RandomKey", StringUtils.getRandomNum(10));
			return "login";
		}
	}

	@RequestMapping(value = "/logout")
	// @RequestParam里边指定request传入参数名称和形参进行绑定。
	// 通过required属性指定参数是否必须要传入
	// 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String logout(HttpSession session) throws Exception {
		session.removeAttribute("currentUser");
		return "login";
	}
	
	@RequestMapping(value = "/forgetPwdShow")
	// @RequestParam里边指定request传入参数名称和形参进行绑定。
	// 通过required属性指定参数是否必须要传入
	// 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String forgetPwd() throws Exception {
		return "forgetPwd";
	}
	
	@RequestMapping(value = "/findPwd")
	// @RequestParam里边指定request传入参数名称和形参进行绑定。
	// 通过required属性指定参数是否必须要传入
	// 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public @ResponseBody ResultReturn findPwd(HttpSession session, String userName, String password, String rePassword, String code) throws Exception {
		ResultReturn data = new ResultReturn();
		data.setReturnCode(CodeType.FAILURE);
		String currentCode = (String) session.getAttribute("userCode");
		if(code != null && currentCode != null && code.trim().equals(currentCode.trim())){
			if(userName != null){
				User user = userMapper.selectByPrimaryKey(userName);
				if(user != null){
					if(password != null && password.equals(rePassword)){
						user.setPassword(password);
						int flag = userMapper.updateByPrimaryKeySelective(user);
						if(flag == 1){
							data.setReturnCode(CodeType.SUCCESS);
						}
					}
				}
				else
				{
					data.setReturnCode(CodeType.FAILURE);
					data.setMapField("userNameNotExist", "用户名不存在");
				}
			}
		}else
		{
			data.setReturnCode(CodeType.FAILURE);
			data.setMapField("result", "验证码错误");
		}
		return data;
	}
}
