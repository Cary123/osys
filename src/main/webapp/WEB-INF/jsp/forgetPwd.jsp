<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>忘记密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	    <!-- 引入Bootstrap CSS框架 awesome字体-->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap/3.3.4/bootstrap.min.css"  rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/fonts/font-awesome/css/font-awesome.css"  rel="stylesheet">
	<!-- 引入主要jQuery 等js框架 -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.js" ></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap/3.3.4/bootstrap.min.js" ></script>
    <script src="${pageContext.request.contextPath}/static/js/jQuery.md5.js" ></script>
    <script src="${pageContext.request.contextPath}/static/js/forgetPwd.js"></script>
    
     <!-- CSS动画框架 -->
    <link href="${pageContext.request.contextPath}/static/css/animate.css"  rel="stylesheet">
    <!-- Yun+ UI css主文件 -->
    <link href="${pageContext.request.contextPath}/static/css/yuntheme.css"  rel="stylesheet">
  </head>
   <body class="gray-bg" background="${pageContext.request.contextPath}/static/image/login-background.jpg">
  	<div class="middle-box text-center loginscreen animated">
               <div>
                <h2 style="color: green; font-size:30px; font-family:华文行楷 ">忘记密码</h2>
            </div>
            <label id="tips"></label>
            
            <form class="m-t" role="form" action="login" method="POST">
            	<div id="divUserName" class="col-xs-12 form-group" style="text-align: left; margin: 0 0; padding: 0 0; display: none">  
					    <lable style="color: gray; font-size:8px" id="lblUserName"></lable>  
				</div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="账户" required="required" name="username" id="username">
                </div>
                
                <div id="divPassword" class="col-xs-12 form-group" style="text-align: left; margin: 0 0; padding: 0 0; display: none">  
					    <lable style="color: gray; font-size:8px" id="lblPassword"></lable>  
				</div>
                <div class="form-group">
                    <input type="password" placeholder="新密码" class="form-control" required="required" name="password" id="password">
                </div>
                
                <div id="divRePassword" class="col-xs-12 form-group" style="text-align: left; margin: 0 0; padding: 0 0; display: none">  
					    <lable style="color: gray; font-size:8px" id="lblRePassword"></lable>  
				</div>
                <div class="form-group">
                    <input type="password" placeholder="确认新密码" class="form-control" required="required" name="rePassword" id="rePassword">
                </div>
                
                <div id="divEmail" class="col-xs-12 form-group" style="text-align: left; margin: 0 0; padding: 0 0; display: none">  
					    <lable style="color: gray; font-size:8px" id="lblEmail"></lable>  
				</div>
                 <div class="form-group">  
				    <div class="input-group col-xs-12">  
				        <input type="text" name="userCode" id="userCode" placeholder="输入验证码" class="form-control" >  
				        <span class="input-group-btn">  
				            <button type="button" class="btn btn-success" id="get_code">获取验证码</button>  
				        </span>  
				    </div>  
				</div> 
             </form>             
                <button class="btn btn-primary block full-width m-b" id="btnSubmit">提交</button>
                <a id="loginHref" class="btn btn-sm btn-orange btn-block" href="${pageContext.request.contextPath}/index" style="display:none">直接登录</a>
  </div>  
 </body>
</html>
