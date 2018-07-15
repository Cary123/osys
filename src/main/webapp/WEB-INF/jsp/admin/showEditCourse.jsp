<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head lang="zh-CN">
<meta charset="utf-8">
<!-- 初始网页宽度为设置屏幕宽度，缩放级别为1.0，禁止用户缩放-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">

<!-- 设置360等双内核的浏览器渲染模式 -->
<meta name="renderer" content="webkit">
<!-- 设置IE支持的最高模式 -->
<meta http-equiv="X-UA-Compatible" content="IE=Edge">

<!-- 禁止移动浏览器转码 -->
<meta http-equiv="Cache-Control" content="no-siteapp">
<title>OSYS</title>
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
<link href="${pageContext.request.contextPath}/static/css/admin/admin.css" rel="stylesheet">
</head>
<body>
	<div id="wrapper">
		<!-- 侧边导航菜单 开始 -->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav metismenu" id="side-menu">
				<li class="nav-header">
						<div class="dropdown profile-element">
							<span><img class="img-circle" height="100px"
								src="${pageContext.request.contextPath}/${sessionScope.currentUser.photo}"
								alt="image">
							</span> <a class="dropdown-toggle" href="#" data-toggle="dropdown">
								<span class="clear"> <span class="block m-t-xs"> <strong
										class="font-bold">OSYS</strong> </span> </span> <span
								class="text-muted text-xs block">超级管理员 <b class="caret"></b>
							</span> </a>
						</div>
						<div class="logo-element">OSYS</div></li>
					<li><a href="#"> <i class="fa fa-th-large"></i> <span
							class="nav-tabel">课程管理</span> <span class="fa arrow"></span> </a>
						<ul class="nav nav-second-level">
							<li><a href="index">添加课程</a></li>
							<li class="active"><a href="javascript:void(0)"
								onclick="showAtRight('editCourseShow')">修改课程信息</a></li>
							<li><a href="javascript:void(0)"
								onclick="showAtRight('listCourseShow')">查看课程</a></li>
						</ul>
					</li>
					<li><a href="#"> <i class="fa fa-bar-chart-o"></i> <span
							class="nav-label">视频管理</span> <span class="fa arrow"></span> </a>
						<ul class="nav nav-second-level collapse">
							<li><a href="javascript:void(0)"
								onclick="showAtRight('addChapterShow')">添加视频信息</a>
							</li>
							<li><a href="javascript:void(0)"
								onclick="showAtRight('editChapterShow')">修改视频信息</a>
							</li>
							<li><a href="javascript:void(0)"
								onclick="showAtRight('listChapterShow')">视频列表</a>
							</li>
						</ul></li>
					<li><a href="#"> <i class="fa fa-bar-chart-o"></i> <span
							class="nav-label">书籍管理</span> <span class="fa arrow"></span> </a>
						<ul class="nav nav-second-level collapse">
							<li><a href="javascript:void(0)"
								onclick="showAtRight('addSectionShow')">添加书籍</a></li>
							<li><a href="javascript:void(0)"
								onclick="showAtRight('editSectionShow')">修改书籍信息</a></li>
							<li><a href="javascript:void(0)"
								onclick="showAtRight('listSectionShow')">书籍列表</a></li>
						</ul>
					</li>
					<!--
					<li><a href="#"> <i class="fa fa-bar-chart-o"></i> <span
							class="nav-label">留言管理</span> <span class="fa arrow"></span> </a>
						<ul class="nav nav-second-level collapse">
							<li><a href="javascript:void(0)"
								onclick="showAtRight('addChatShow')">添加留言</a></li>
							<li><a href="javascript:void(0)"
								onclick="showAtRight('listChatShow')">查看留言</a></li>
						</ul>
					</li>
					-->
				</ul>
			</div>
		</nav>
		<!-- 侧边导航菜单 结束 -->

		<!-- 右侧内容 开始 -->
		<div class="gray-bg" id="page-wrapper">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary"
							href="javascript:void(0)"><i class="fa fa-bars"></i> </a>
						<form class="navbar-form-custom navbar-left">
							<div class="form-group">
								<input class="form-control" id="top-search" name="keywords" value="${keywords}"
									type="text" placeholder="请输入您要查找的内容……">
							</div>
						</form>
						<button style="margin-top: 10px" class="btn btn-primary" onclick="SearchBook()">搜索</button>
						</form>
					</div>
					<ul class="nav navbar-top-links navbar-left"
						style="margin-left: 200px;margin-top: 10px">
						<li><label style="color: green; font-size: 30px">网上学习平台后台管理</label>
						</li>
					</ul>
					<ul class="nav navbar-top-links navbar-right">
						<li><span class="m-r-sm text-muted welcome-message">欢迎
								"${sessionScope.currentUser.username}" 登录成功</span></li>
						<li><a href="${pageContext.request.contextPath}/logout"> <i class="fa fa-sign-out"></i> 退出 </a>
						</li>
					</ul>
				</nav>
			</div>

			<div class="row  border-bottom white-bg dashboard-header">
				<div id="mainBody" class="mainBody">
					<form role="form" id="uploadForm" enctype="multipart/form-data">
						<div class="form-group">
							<label for="name">课程ID(不能修改) </label> <input type="text"
								class="form-control" name="courseId"
								value="${book.bookid}">
						</div>
						<div class="form-group">
							<label for="name">课程名 </label> <input type="text"
								class="form-control" placeholder="请输入课程名" name="courseName"
								value="${book.bookname}">
						</div>
						<div class="form-group">
							<label for="name">课程描述 </label> <input type="text"
								class="form-control" placeholder="请输入课程描述" name="courseDescribe"
								value="${book.bookdescript}">
						</div>
						<div class="form-group">
							<input type="file" id="file" name="file">
						</div>
						<div class="form-group">
							<label for="name">课程名创建者</label> <input type="text"
								class="form-control" placeholder="请输入名称" name="courseCreator"
								value="${book.bookcreater}">
						</div>
					</form>
					<button class="btn btn-primary" onclick="modifyImage()">修改</button>
				</div>
			</div>
		</div>
	</div>

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
	<script src="${pageContext.request.contextPath}/static/js/admin/course.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/admin/chapter.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/admin/section.js"></script>
</body>
</html>