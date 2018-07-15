<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.joseph.osys.pojos.Chapter"%>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<label>请选择对应的书本</label>
	<button type="button" class="btn btn-primary" onclick="showModifyBookList()">点击获取书籍</button>
	<div class="form-group">
		<div class="input-group col-xs-12">
			<div class="input-group-btn">
				<select id="bookList" name="bookList"
					class="selectpicker show-tick form-control col-sm-10"
					onchange="showDeleteList()"
					data-live-search="false">
					<option>--</option>
				</select>
			</div>
		</div>
	</div>
	<table class="table">
		<thead>
			<tr>
				<td>章节号</td>
				<td>章节名</td>
				<td>书本号</td>
				<td>视频连接</td>
				<td>删除</td>
				<td>编辑</td>
			</tr>
		</thead>
		<tbody id="chapterDeleteList">
			
		</tbody>
	</table>
</body>
</html>
