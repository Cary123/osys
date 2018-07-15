<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>OSYS</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 引入Bootstrap CSS框架 awesome字体-->
<link href="${pageContext.request.contextPath}/static/css/bootstrap/3.3.4/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/fonts/font-awesome/css/font-awesome.css"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/static/css/plugins/blueimp/css/blueimp-gallery.min.css"
	rel="stylesheet">
<!-- CSS动画框架 -->
<link href="${pageContext.request.contextPath}/static/css/animate.css" rel="stylesheet">
<!-- Yun+ UI css主文件 -->
<link href="${pageContext.request.contextPath}/static/css/yuntheme.css" rel="stylesheet">

<style type="text/css">
.nav.navbar-top-links .linkCss {
	font-family: '微软雅黑';
	font-weight: bold;
	font-size: 20px;
	color: #ffffff;
	display: inline-block;
}

.nav>li>a:hover,.nav>li>a:focus {
	text-decoration: none;
	background-color: #222;
}
</style>
</head>

<body>
<body
	class="fixed-sidebar no-skin-config full-height-layout  pace-done mini-navbar">
	<div id="wrapper">
		<!-- 侧边导航菜单 开始 -->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav metismenu" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<span><img class="img-circle" src="img/profile_small.jpg"
								alt="image">
							</span> <a class="dropdown-toggle" href="#" data-toggle="dropdown">
								<span class="clear"> <span class="block m-t-xs"> </span>
							</span> <span class="text-muted text-xs block">个人中心 <b
									class="caret"></b>
							</span> </a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">
								<li><a href="${pageContext.request.contextPath}/userInfoShow">个人信息</a>
								</li>
								<li><a href="${pageContext.request.contextPath}/changPwdShow">修改密码</a>
								</li>
								<li><a href="${pageContext.request.contextPath}/contactShow">联系我们</a>
								</li>
								<li class="divider"></li>
								<li><a href="${pageContext.request.contextPath}/logout">退出</a>
								</li>
							</ul>
						</div></li>
				</ul>
			</div>
		</nav>
		<!-- 侧边导航菜单 结束 -->

		<!-- 右侧内容 开始 -->
		<div class="white-bg" id="page-wrapper">
			<!-- 右侧顶部导航div 开始 -->
			<div class="row border-bottom">
				<nav style="background-color: #222222"
					class="navbar navbar-static-top navbar-inverse" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary"
							href="javascript:void(0);"><i class="fa fa-bars"></i> </a>
					</div>

					<ul class="nav navbar-top-links navbar-left">
						<li role="presentation"><div
								style="width: 150px; height:60px; text-align:center; margin:0 auto">
								<a class="linkCss" href="${pageContext.request.contextPath}/index">在线课程 </a>
							</div>
						</li>
						<li role="presentation"><div
								style="width: 150px; height:60px; text-align:center; margin:0 auto">
								<a class="linkCss" href="${pageContext.request.contextPath}/main/video">视频精讲 </a>
							</div>
						</li>
						<li role="presentation"><div
								style="width: 150px; height:60px; text-align:center; margin:0 auto">
								<a class="linkCss" href="${pageContext.request.contextPath}/main/discuss">讨论区</a>
							</div>
						</li>
					</ul>

					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<label class="sr-only"></label> <input style="width:320px"
								type="text" class="form-control" placeholder="搜索" />
						</div>
						<button id="btnKeyWord" class="btn btn-primary navbar-btn">搜索</button>
					</form>

					<ul class="nav navbar-top-links navbar-right">
						<li><div>
								<a href="userInfoShow"><span><img class="img-circle"
										height="35px" src="${pageContext.request.contextPath}/${sessionScope.currentUser.photo}"
										alt="image">
								</span>
								</a>
							</div>
						</li>
						<li class="dropdown"><a class="dropdown-toggle count-info"
							style="" data-toggle="dropdown" href="#"> <i
								class="fa fa-envelope"></i> <span class="label label-warning">16</span>
						</a>

							<ul class="dropdown-menu dropdown-messages">
								<li>
									<div class="dropdown-messages-box">
										<a class="pull-left" href="profile.html"> <img
											class="img-circle" src="${pageContext.request.contextPath}/img/a7.jpg" alt="image"> </a>
										<div class="media-body">
											<small class="pull-right">46h前</small> <strong>国民老公</strong>又在微博放料啦，某某女演员……<br>
											<small class="text-muted">3 前 7:58 下午 - 10.06.2014</small>
										</div>
									</div></li>
								<li class="divider"></li>
								<li>
									<div class="dropdown-messages-box">
										<a href="profile.html" class="pull-left"> <img alt="image"
											class="img-circle" src="${pageContext.request.contextPath}/img/a4.jpg"> </a>
										<div class="media-body ">
											<small class="pull-right text-navy">5小时前</small> <strong>股票大跌</strong>
											小马哥不再是首富了。 <strong>———来自财经网</strong>. <br> <small
												class="text-muted">昨天 1:21 下午 - 11.06.2014</small>
										</div>
									</div></li>
								<li class="divider"></li>
								<li>
									<div class="dropdown-messages-box">
										<a href="profile.html" class="pull-left"> <img alt="image"
											class="img-circle" src="${pageContext.request.contextPath}/${sessionScope.currentUser.photo}"> </a>
										<div class="media-body ">
											<small class="pull-right">23小时前</small> <strong>风姐</strong>
											爱上 <strong>小马哥啦！</strong>. <br> <small
												class="text-muted">2天前 2:30 上午 - 11.06.2014</small>
										</div>
									</div></li>
								<li class="divider"></li>
								<li>
									<div class="text-center link-block">
										<a href="mailbox.html"> <i class="fa fa-envelope"></i> <strong>查看全部消息</strong>
										</a>
									</div></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle count-info"
							data-toggle="dropdown" href="index.html#"> <i
								class="fa fa-bell"></i> <span class="label label-primary">8</span>
						</a>
							<ul class="dropdown-menu dropdown-alerts">
								<li><a href="mailbox.html">
										<div>
											<i class="fa fa-envelope fa-fw"></i> 你有8条未读消息 <span
												class="pull-right text-muted small">4 分钟前</span>
										</div> </a></li>
								<li class="divider"></li>
								<li><a href="profile.html">
										<div>
											<i class="fa fa-qq fa-fw"></i> 3条新回复 <span
												class="pull-right text-muted small">12 分钟前</span>
										</div> </a></li>
								<li class="divider"></li>
								<li><a href="grid_options.html">
										<div>
											<i class="fa fa-upload fa-fw"></i> 服务器重启 <span
												class="pull-right text-muted small">4 分钟前</span>
										</div> </a></li>
								<li class="divider"></li>
								<li>
									<div class="text-center link-block">
										<a href="notifications.html"> <strong>查看全部提醒</strong> <i
											class="fa fa-angle-right"></i> </a>
									</div></li>
							</ul></li>
						<li><a href="${pageContext.request.contextPath}/logout"> <i class="fa fa-sign-out"></i> 退出
						</a></li>
					</ul>
				</nav>
			</div>
			<!-- 右侧顶部导航div 结束 -->

			<div id="info"
				class="row wrapper border-bottom white-bg page-heading">
				<ul class="nav nav-tabs">
					<li><a class="linkCss" href="#userInfo" data-toggle="tab">个人信息</a>
					</li>
					<li><a class="linkCss" href="#changePwd" data-toggle="tab">修改密码</a>
					</li>
					<li><a class="linkCss" href="#bindEmail" data-toggle="tab">绑定邮箱</a>
					</li>
				</ul>
			</div>

			<div
				class="tab-content wrapper wrapper-content  animated fadeInRight">
				<div id="userInfo" class="tab-pane active">
					<form class="form-horizontal col-sm-6" role="form">
						<div class="form-group">
							<label for="photo" class="col-sm-2 control-label">头&nbsp&nbsp&nbsp&nbsp像：</label><label  style="color: red">（点击头像修改照片）</label>
							<div class="col-sm-10">
								<a id="photo" href="uploadPhotoShow"><span><img
										class="img-circle" src="${pageContext.request.contextPath}/${sessionScope.currentUser.photo}" height="100px"
										alt="image">
								</span>
								</a>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名：</label>
							<div class="col-sm-10">
								<label class="form-control" id="username">${sessionScope.currentUser.username}</label>
							</div>
						</div>

						<div class="form-group">
							<label for="sex" class="col-sm-2 control-label">性&nbsp&nbsp&nbsp&nbsp别：</label>
							<div class="col-sm-10">
								<label class="form-control" id="sex">${sessionScope.currentUser.sex}</label>
							</div>
						</div>

						<div class="form-group">
							<label for="phone" class="col-sm-2 control-label">手&nbsp&nbsp&nbsp&nbsp机：</label>
							<div class="col-sm-10">
								<label class="form-control"id="phone">${sessionScope.currentUser.phone}</label>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">邮&nbsp&nbsp&nbsp&nbsp箱：</label>
							<div class="col-sm-10">
								<label class="form-control" id="email">${sessionScope.currentUser.email}</label>
							</div>
						</div>

					</form>
				</div>

				<div id="changePwd" class="tab-pane">
					<form role="form" class="form-horizontal col-sm-6" action="changePwd" method="post">
						<label id="tips"> </label>
						<div class="form-group">
							<label for="oldPassword" class="col-sm-2 control-label">原密码：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" placeholder="原密码"
								required="required" name="oldPassword" id="oldPassword">
							</div>
						</div>
						
						<div class="form-group">
							<label for="newPassword" class="col-sm-2 control-label">新密码：</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" placeholder="新密码"
								required="required" name="newPassword" id="newPassword">
							</div>
						</div>
						
						<div class="form-group">
							<label for="rePassword" class="col-sm-2 control-label">确认密码：</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" placeholder="确认密码"
								required="required" name="rePassword" id="rePassword">
							</div>
						</div>
						<div class="form-group">
							<button id="changePwd"
							class="btn btn-primary block full-width m-b">确认</button>
						</div>
					</form>
				</div>

				<div id="bindEmail" class="tab-pane">
					<form class="form-horizontal col-sm-5" role="form">
						<div class="form-group">
							<label for="photo" class="col-sm-2 control-label">所用邮箱：</label>
							<div class="col-sm-10">
								<label class="col-sm-1 control-label">${sessionScope.currentUser.email}</label>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="username"
									name="username" placeholder="请输入用户名：">
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="username"
									name="username" placeholder="请输入用户名：">
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">用户名：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="username"
									name="username" placeholder="请输入用户名：">
							</div>
						</div>

						<button type="submit" class="btn btn-primary block full-width m-b">确认</button>
					</form>
				</div>
			</div>
		</div>


		<jsp:include page="/static/footer.html" flush="true"/>
		<!-- 右侧内容 结束 -->
	</div>
	</div>
	 <script type="text/javascript">
      		$("#changePwd").click(function(){
      			var oldPassword = $("oldPassword").val();
      			var newPassword = $("newPassword").val();
      			var rePassword = $("rePassword").val();
      			if(oldPassword == "" || newPassword == "" || rePassword == "")
      			{
      				$("#tips").html("<strong style='color:#f00;'>你需要填写相关的数据</strong>");
      				return;
      			}
      			else if(!(/^\w+$/.test($('#oldPassword').val()) && $('#oldPassword').val().length > 5 && $('#oldPassword').val().length < 17 && /^\w+$/.test($('#newPassword').val()) && $('#newPassword').val().length > 5 && $('#newPassword').val().length < 17))
      			{
      				$("#tips").html("<strong style='color:#f00;'>密码只能为6-16个英文、数字和下划线！</strong>");
      				return;
      			}
      			else if(newPassword != rePassword)
      			{
      				$("#tips").html("<strong style='color:#f00;'>两次密码输入不一致！</strong>");
      				return;
      			}
      			else
      			{
      			 $.ajax({  
	             type: 'post',  
	             dataType: 'json',
 	              //contentType:'application/json;charset=UTF-8',
 	             contentType: "application/x-www-form-urlencoded",
	             url :"modifyPwd",
            	 data:{
            		 oldPassword: oldPassword,
            		 newPassword: newPassword,
            		 rePassword: rePassword
            	 },
	             success: function(data){  
	                   if(data.code == 1){
	                	   
	                   }else{
	           			   $('#tips').html("<strong style='color:#f00;'>"+data.field.result+"</strong>");
	                   }
	               },
	           error : function() {
	               return false;  
	            }   
	           }); 
      			}
      		})
      </script>

	<!-- 引入主要jQuery 等js框架 -->
	<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/bootstrap/3.3.4/bootstrap.min.js"></script>

	<script src="${pageContext.request.contextPath}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<!-- Custom and plugin javascript -->
	<script src="${pageContext.request.contextPath}/static/js/inspinia.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/plugins/pace/pace.min.js"></script>

	<!-- blueimp gallery -->
	<script src="${pageContext.request.contextPath}/static/js/plugins/blueimp/jquery.blueimp-gallery.min.js"></script>
</body>
</html>
