<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.joseph.osys.pojos.Chapter"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <table class="table">
	   <thead>
	      <tr>
		      <td>章节号</td>
		      <td>章节名</td>
		      <td>书本号</td>
		      <td>视频链接</td>
		   </tr>
		   </thead>
		   <tbody>
		<c:forEach items="${sessionScope.chapters}" var="chapter" varStatus="vs">
			<c:choose>
				<c:when test="${vs.count mod 2==0 }">
					<tr bgcolor="yellow">
				</c:when>
				<c:otherwise>
					<tr>
				</c:otherwise>
			</c:choose>
			<td>
				${chapter.chapternameid}
			</td>
			<td>
				${chapter.chaptername}
			</td>
			<td>
			   ${chapter.bookid}
			</td>
			<td>
			   ${chapter.videourl }
			</td>
			</tr>
			</tbody>
		</c:forEach>
		</table>
  </body>
</html>
