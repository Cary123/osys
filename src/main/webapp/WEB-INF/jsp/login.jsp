<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <meta charset="utf-8">
    <!-- 初始网页宽度为设置屏幕宽度，缩放级别为1.0，禁止用户缩放-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

    <!-- 设置360等双内核的浏览器渲染模式 -->
    <meta name="renderer" content="webkit">
    
    <!-- 设置IE支持的最高模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">

    <!-- 禁止移动浏览器转码 -->
    <meta http-equiv="Cache-Control" content="no-siteapp">
    
    <!-- 网站标志 -->
    <!-- <link rel="icon" type="image/png" href="favicon.png"> -->

    <title>登录</title>
    <!-- 网站描述 -->
    <meta name="description" content="Online Study System">
    
    <!-- 网站SEO关键词 -->
    <meta name="keywords" content="Online Study System">
    
    <!-- 引入Bootstrap CSS框架 awesome字体-->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap/3.3.4/bootstrap.min.css"  rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/fonts/font-awesome/css/font-awesome.css"  rel="stylesheet">

    <!-- CSS动画框架 -->
    <link href="${pageContext.request.contextPath}/static/css/animate.css"  rel="stylesheet">
    <!-- Yun+ UI css主文件 -->
    <link href="${pageContext.request.contextPath}/static/css/yuntheme.css"  rel="stylesheet">
</head>
<body class="gray-bg" background="${pageContext.request.contextPath}/static/image/login-background.jpg">
    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>
                <h2 style="color: green; font-size:50px; font-family:华文行楷 ">网上学习平台</h2>
            </div>
            <label id="tips"></label>
            <form class="m-t" role="form">
            	<div id="divName" class="col-xs-12 form-group" style="text-align: left; margin: 0 0; padding: 0 0; display: none">  
					    <lable style="color: gray; font-size:8px" id="lblName"></lable>  
				</div>
                <div class="form-group">
                    <input type="text" class="form-control" id="username" placeholder="用户名" required="required" name="username" id="username">
                </div>
                <div id="divPassword" class="col-xs-12 form-group" style="text-align: left; margin: 0 0; padding: 0 0; display: none">  
					    <lable style="color: gray; font-size:8px" id="lblPassword"></lable>  
				</div>
                <div class="form-group">
                    <input type="password" class="form-control" id="password" placeholder="密码" required="required" name="password" id="password">
                </div>
                
                 <button class="btn btn-primary block full-width m-b" onclick="encryptionPassword()">登录</button>  
            </form>                  
               
                <a href="${pageContext.request.contextPath}/forgetPwdShow" ><small>忘记密码?</small></a>
                <p class="text-muted text-center"><small>还没有帐号?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="${pageContext.request.contextPath}/regist">注册新用户</a>
            
            <p class="m-t"> <small>主题前端框架基于 Bootstrap 3 &copy; 2017</small> </p>
        </div>
    </div>

    <!-- 引入主要jQuery 等js框架 -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.js" ></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap/3.3.4/bootstrap.min.js" ></script>
    <script src="${pageContext.request.contextPath}/static/js/jQuery.md5.js" ></script>
    <script src="${pageContext.request.contextPath}/static/js/login.js" ></script>
	<script type="text/javascript">
	function encryptionPassword(){              
	     var hash =$.md5($("#password").val());    
	     $("#password").val(hash);    
	    }
	</script>
</body>
  </body>
</html>
