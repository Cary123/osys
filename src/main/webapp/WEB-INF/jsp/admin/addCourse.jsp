<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
     <form role="form"  id="uploadForm" enctype="multipart/form-data">
      <div class="form-group">
        <label for="name">课程名 </label>
        <input type="text" class="form-control" placeholder="请输入课程名" name="courseName">
      </div>
      <div class="form-group">
        <label for="name">课程描述 </label>
        <input type="text" class="form-control" placeholder="请输入课程描述" name="courseDescribe">
      </div>
      <div class="form-group">
        <label for="inputfile">请上传课程图片</label>
        <input type="file" id="file" name="file">
      </div>
      <div class="form-group">
        <label for="name">课程名创建者</label>
        <input type="text" class="form-control" placeholder="请输入名称" name="courseCreator">
      </div>
   </form>
    <button class="btn btn-primary" onclick="uploadImage()">提交</button>
  </body>
</html>
