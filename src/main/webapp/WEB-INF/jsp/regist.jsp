<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head lang="zh-CN">
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
    <title>注册</title>
    <!-- 网站描述 -->
    <meta name="description" content="">
    <!-- 网站SEO关键词 -->
    <meta name="keywords" content="">
    
    <!-- 引入Bootstrap CSS框架 awesome字体-->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap/3.3.4/bootstrap.min.css"  rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/fonts/font-awesome/css/font-awesome.css"  rel="stylesheet">

    <link href="${pageContext.request.contextPath}/static/css/plugins/iCheck/custom.css"  rel="stylesheet">

    <!-- CSS动画框架 -->
    <link href="${pageContext.request.contextPath}/static/css/animate.css"  rel="stylesheet">
    <!-- Yun+ UI css主文件 -->
    <link href="${pageContext.request.contextPath}/static/css/yuntheme.css"  rel="stylesheet">
</head>
<body class="gray-bg" background="${pageContext.request.contextPath}/static/image/login-background.jpg">
    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>
                <h2 style="color: green; font-size:30px; font-family:华文行楷 ">注册一个新帐号</h2>
            </div>
            <label id="tips"></label>
            <form class="m-t">
            	<div id="divUserName" class="col-xs-12 form-group" style="text-align: left; margin: 0 0; padding: 0 0;">  
					    <lable style="color: gray; font-size:8px" id="lblUserName">用户名只能为2-16字母数字或者下划线</lable>  
				</div>
                <div class="form-group">
                    <input type="text" class="form-control" name="userName" id="userName" placeholder="用户名" required="required">
                </div>
                <div id="divPassword" class="col-xs-12 form-group" style="text-align: left; margin: 0 0; padding: 0 0; display: none">  
					    <lable style="color: gray; font-size:8px" id="lblPassword"></lable>  
				</div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" id="password" placeholder="密码" required="required">
                </div>
                <div id="divRePassword" class="col-xs-12 form-group" style="text-align: left; margin: 0 0; padding: 0 0; display: none">  
					    <lable style="color: gray; font-size:8px" id="lblRePassword"></lable>  
				</div>
                <div class="form-group">
                    <input type="password" class="form-control" name="rePassword" id="rePassword" placeholder="确认密码" required="required">
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" name="userAge" id="userAge" placeholder="年龄" required="required">
                </div>
                <div id="divUserPhone" class="col-xs-12 form-group" style="text-align: left; margin: 0 0; padding: 0 0; display: none">  
					    <lable style="color: gray; font-size:8px" id="lblUserPhone"></lable>  
				</div>
                <div class="form-group">
                    <input type="text" class="form-control" name="userPhone" id="userPhone" placeholder="手机号(可不用填写)" >
                </div>
                <div class="form-group">
                    <input type="radio" name="userSex" value="man" checked="checked">男
                    <input type="radio" name="userSex" value="woman" >女
                </div>
                
                <div id="divEmail" class="col-xs-12 form-group" style="text-align: left; margin: 0 0; padding: 0 0; display: none">  
					    <lable style="color: gray; font-size:8px" id="lblEmail"></lable>  
				</div>
                <div class="form-group">
                    <input type="email" class="form-control" id="userEmail" name="userEmail" placeholder="邮箱" required="required">
                </div>
                <div id="divCode" class="col-xs-12 form-group" style="text-align: left; margin: 0 0; padding: 0 0; display: none">  
					    <lable style="color: gray; font-size:8px" id="lblCode"></lable>  
				</div>
                <div class="form-group">  
				    <div class="input-group col-xs-12">  
				        <input type="text" name="userCode" id="userCode" placeholder="输入验证码" class="form-control" >  
				        <span class="input-group-btn">  
				            <button type="button" class="btn btn-success" id="get_code">获取验证码</button>  
				        </span>  
				    </div>  
				</div> 
                <button type="button" class="btn btn-primary block full-width m-b" id="regist_button" >注册</button>

                <p class="text-muted text-center"><small>已有帐号?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="index" >直接登录</a>
            </form>
            <p class="m-t"> <small>前端框架基于 Bootstrap 3 &copy; 2015</small> </p>
        </div>
    </div>

    <!-- 引入主要jQuery 等js框架 -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.js" ></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap/3.3.4/bootstrap.min.js" ></script>
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath}/static/js/plugins/iCheck/icheck.min.js" ></script>
    <script src="${pageContext.request.contextPath}/static/js/jQuery.md5.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/regist.js"></script>
    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

</body>
</html>