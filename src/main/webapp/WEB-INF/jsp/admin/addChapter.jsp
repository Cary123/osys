<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

</head>

<body>
	<form role="form" id="uploadPPTForm">
		<div class="form-group">
			<label style="color: blue">课程列表</label>
			<button type="button" class="btn btn-primary" onclick="showBookList()">选择课程</button>
			<select id="bookList" name="bookList" onchange="showExistChapterList()"
				class="selectpicker show-tick form-control" data-live-search="false">
				<option>--</option>
			</select>
		</div>
		<div class="form-group">
			<label for="bookId">当前课程编号：</label> <input type="number"
				class="form-control" id="bookId" name="bookId" readonly="readonly"
				placeholder="请输入章号">
		</div>
		<div class="form-group">
			<label style="color: blue">已添加的课程章节如下</label>
			<ul class="list-group" id="chapterList">

			</ul>
		</div>
		
		<div class="form-group">
			<label style="color: blue">继续录入后续章节</label>
		</div>
		<div class="form-group">
			<label for="name">章序</label> <input type="number"
				class="form-control" id="chapterNameId" name="chapterNameId"
				placeholder="请输入章号">
		</div>
		<div class="form-group">
			<label for="name">章名</label> <input type="text" class="form-control"
				id="chapterName" name="chapterName" placeholder="请输入章名">
		</div>

		<div class="form-group">
			<label for="name">上传本章视频</label> 
			<input type="file" id="inputfile" name="file">
		</div>
	</form>
	<button type="submit" class="btn btn-primary"
		onclick="uploadPPTImage()">提交</button>
	<script src="static/js/jquery-2.1.1.js"></script>
</body>
</html>
