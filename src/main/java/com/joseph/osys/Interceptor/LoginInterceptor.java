package com.joseph.osys.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	private static final String[] IGNORE_URI = {"/index", "/registSubmit", "/login", "/regist","/getCode","/forgetPwdShow", "/findPwd"};
	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		boolean flag = false;
		HttpSession session = request.getSession();
		String url = request.getRequestURL().toString();
		for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
		if (!flag) {
			if(session.getAttribute("currentUser") == null)
			{
			  request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			  //返回true代表继续往下执行
			  return false;
			 }else{
				return true;
			}
		}
		else
		{
			return true;
		}
	}
}
