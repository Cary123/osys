<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.joseph.osys.pojos.Note"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
      <table class="table">
	   <thead>
	      <tr>
		      <td>留言</td>
		      <td>留言时间</td>
		      <td>书籍</td>
		      <td>留言者</td>
		      <td>删除</td>
		   </tr>
		   </thead>
		   <tbody>
		<c:forEach items="${sessionScope.notes}" var="note" varStatus="vs">
		
			<c:choose>
				<c:when test="${vs.count mod 2==0 }">
					<tr bgcolor="yellow">
				</c:when>
				<c:otherwise>
					<tr>
				</c:otherwise>
			</c:choose>
			<td>
				${note.notecontent}
			</td>
			<td>
				${note.notetime}
			</td>
			<td>
			   ${note.bookid}
			</td>
			<td>
			   ${note.creater}
			</td>
			<td>
			   <a href="javascript:void(0)" onclick="deleteChat(${note.noteid})"><img src = "static/image/ico_error.png"/></a>
			</td>
			</tr>
			</tbody>
		</c:forEach>
		</table>
  </body>
</html>
