<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.joseph.osys.pojos.Sector"%>
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
     <table class="table">
	   <thead>
	      <tr>
		      <td>sector id</td>
		      <td>sector name</td>
		      <td>chapter id</td>
		      <td>PDF</td>
		   </tr>
		   </thead>
		   <tbody>
		<c:forEach items="${sectors}" var="sector" varStatus="vs">
		
			<c:choose>
				<c:when test="${vs.count mod 2==0 }">
					<tr bgcolor="yellow">
				</c:when>
				<c:otherwise>
					<tr>
				</c:otherwise>
			</c:choose>
			<td>
				${sector.sectorid}
			</td>
			<td>
				${sector.sectorname}
			</td>
			<td>
			   ${sector.chapterid}
			</td>
			<td>
			   ${sector.pdfurl}
			</td>
			</tr>
			</tbody>
		</c:forEach>
		</table>
  </body>
</html>
