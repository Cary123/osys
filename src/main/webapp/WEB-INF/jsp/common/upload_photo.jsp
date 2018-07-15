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

<title>user information</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 引入Bootstrap CSS框架 awesome字体-->
<!-- 引入Bootstrap CSS框架 awesome字体-->
<link href="static/css/bootstrap/3.3.4/bootstrap.min.css"
	rel="stylesheet">
<link href="static/fonts/font-awesome/css/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet" href="static/css/cropper/cropper.min.css" />
<link rel="stylesheet" href="static/css/cropper/main.css" />
<!-- 引入主要jQuery 等js框架 -->
<script src="static/js/jquery-2.1.1.js"></script>
<script src="static/js/bootstrap/3.3.4/bootstrap.min.js"></script>
<script src="static/js/cropper/cropper.min.js"></script>
<script src="static/js/cropper/main.js"></script>
<style type="text/css">
.linkCss {
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
<div>
	<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand linkCss" href="${pageContext.request.contextPath}/index">在线课程 </a>
    </div>
    <div>
        <ul class="nav navbar-nav navbar-left">
			<li role="presentation">  
					<a class="linkCss" href="${pageContext.request.contextPath}/main/video">视频精讲 </a>
			</li>
			<li role="presentation">  
					<a class="linkCss" href="${pageContext.request.contextPath}/main/discuss">讨论区</a>
			</li>
		 </ul>

		<form class=" nav navbar-nav navbar-form navbar-right" role="search">
			<div class="form-group">
				<label class="sr-only"></label> <input style="width:320px"
					type="text" class="form-control" placeholder="搜索" />
			</div>
			<button id="btnKeyWord" class="btn btn-primary navbar-btn">搜索</button>
		</form>

    </div>
    </div>
   </nav>

</div>


<div class="container" id="crop-avatar">
	<!-- Current avatar -->
	<div>
		<h2 style="text-align: center; color:green">点击图片上传头像</h2>
		<h4 style="text-align: center; color:red" ><a href="userInfoShow">个人中心</a></h4>
	</div>
	<div class="avatar-view" title="Change the avatar">
		<img src="${sessionScope.currentUser.photo}" alt="Avatar">
	</div>

	<!-- Cropping modal -->
	<div class="modal fade" id="avatar-modal" aria-hidden="true"
		aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form id="uploadForm" class="avatar-form" action="imgCut"
					enctype="multipart/form-data" method="post" accept="image/*">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" id="avatar-modal-label">更改头像</h4>
					</div>
					<div class="modal-body">
						<div class="avatar-body">

							<!-- Upload image and data -->
							<div class="avatar-upload">
								<input type="hidden" class="avatar-src" name="avatar_src">
								<input type="hidden" class="avatar-data" name="avatar_data">
								<label for="avatarInput" class="btn btn-primary">选择图片</label> <input
									type="file" class="avatar-input" id="avatarInput"
									name="avatar_file" style="display: none;" accept="image/*">
							</div>

							<!-- Crop and preview -->
							<div class="row">
								<div class="col-md-9">
									<div class="avatar-wrapper"></div>
								</div>
								<div class="col-md-3">
									<div class="avatar-preview preview-lg"></div>
									<div class="avatar-preview preview-md"></div>
									<div class="avatar-preview preview-sm"></div>
								</div>
							</div>

							<div class="row avatar-btns">
								<div class="col-md-9">
									<div class="btn-group">
										<button type="button" class="btn btn-primary"
											data-method="rotate" data-option="-90"
											title="Rotate -90 degrees">Rotate Left</button>
										<button type="button" class="btn btn-primary"
											data-method="rotate" data-option="-15">-15deg</button>
										<button type="button" class="btn btn-primary"
											data-method="rotate" data-option="-30">-30deg</button>
										<button type="button" class="btn btn-primary"
											data-method="rotate" data-option="-45">-45deg</button>
									</div>
									<div class="btn-group">
										<button type="button" class="btn btn-primary"
											data-method="rotate" data-option="90"
											title="Rotate 90 degrees">Rotate Right</button>
										<button type="button" class="btn btn-primary"
											data-method="rotate" data-option="15">15deg</button>
										<button type="button" class="btn btn-primary"
											data-method="rotate" data-option="30">30deg</button>
										<button type="button" class="btn btn-primary"
											data-method="rotate" data-option="45">45deg</button>
									</div>
								</div>
								<div class="col-md-3">
									<button class="btn btn-primary btn-block avatar-save">Done</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /.modal -->

	<!-- Loading state -->
	<div class="loading" aria-label="Loading" role="img" tabindex="-1">
	</div>
</div>
</body>
</html>

