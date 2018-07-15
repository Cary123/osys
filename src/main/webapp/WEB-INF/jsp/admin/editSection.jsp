<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.joseph.osys.pojos.Sector"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <title>OSYS</title>
    
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
	  <label>请选择对应的课程</label>
		<button type="button" class="btn btn-primary" onclick="showModifyBookListv2()">课程选择</button>
		<div class="form-group">
			<div class="input-group col-xs-12">
				<div class="input-group-btn">
					<select id="bookList" name="bookList"
						class="selectpicker show-tick form-control col-sm-10"
						onchange="showModifyChapterList()"
						data-live-search="false">
						<option>--</option>
					</select>
				</div>
			</div>
		</div>
		<label>请选择对应的章节</label>
		<div class="form-group">
			<div class="input-group col-xs-12">
				<div class="input-group-btn">
					<select id="chapterList" name="bookList"
						class="selectpicker show-tick form-control col-sm-10"
						onchange="showDeleteSectorList()"
						data-live-search="false">
						<option>--</option>
					</select>
				</div>
			</div>
		</div>
       <table class="table">
	   <thead>
	      <tr>
		      <td>小节编号</td>
		      <td>小节名称</td>
		      <td>章编号</td>
		      <td>PDF地址</td>
		      <td>删除</td>
		      <td>编辑</td>
		   </tr>
		   </thead>
		   <tbody id="sectorDeleteList">
		
		   </tbody>
		</table>
  </body>
</html>
