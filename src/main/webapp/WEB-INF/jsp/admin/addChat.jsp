<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
      <form role="form" id="chatForm">
      <div class="form-group" >
        <label for="name">note</label>
        <input type="text" class="form-control" placeholder="请输入留言" name="noteDes" id="noteDes" >
      </div>
      <div class="form-group">
        <label for="name">书籍id</label>
        <input type="text" class="form-control" placeholder="请输入节数" name="sectorId" id="sectorId">
      </div>
   </form>
   <Button type="submit" onclick="addChat()">提交</Button>
  </body>
</html>
