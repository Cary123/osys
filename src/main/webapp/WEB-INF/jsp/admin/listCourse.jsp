<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.joseph.osys.pojos.Book"%>
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
		      <td>课程图片</td>
		      <td>课程名</td>
		      <td>描述</td>
		      <td>创建者</td>
		   </tr>
		   </thead>
		   <tbody>
		<c:forEach items="${books}" var="course" varStatus="vs">
		
			<c:choose>
				<c:when test="${vs.count mod 2==0 }">
					<tr bgcolor="#fce5cd">
				</c:when>
				<c:otherwise>
					<tr bgcolor="#f4cccc">
				</c:otherwise>
			</c:choose>
			<td>
				<img style="height:120px" src= "${course.bookimage}"></img>
			</td>
			<td>
				${course.bookname}
			</td>
			<td>
				${course.bookdescript}
			</td>
			<td>
			   ${course.bookcreater}
			</td>
			</tr>
			</tbody>
		</c:forEach>
		</table>
		<div id="page-nav"
			style="width:100%; float:left; margin-bottom: 100px; margin-top:50px">
			<ul class="pages" id="pageNav" tag-current="${currentPage}"
				tag-total="${totalCount}">
				<c:if test="${currentPage > 1}">
					<li class="pgNext"><a href="javascript:void(0)" onclick="showAtRight('${pageContext.request.contextPath}/listCourseShow?keywords=${keywords}&currentPage=1')"
						id = "pageHome" name="pageHome">首页</a>
					</li>
					<li class="pgNext"><a href="javascript:void(0)" onclick="showAtRight('${pageContext.request.contextPath}/listCourseShow?keywords=${keywords}&currentPage=${currentPage-1}')" id="upPage" name="upPage">上一页</a>
					</li>
				</c:if>

				<c:if test="${totalCount-currentPage >= 0}">
					<li class="page-number pgCurrent"><a href="javascript:void(0)"
						onclick="showAtRight('${pageContext.request.contextPath}/listCourseShow?keywords=${keywords}&currentPage=${currentPage}')" id = "pageFirst" name="pageFirst">${currentPage}</a>
					</li>
				</c:if>
				<c:if test="${totalCount-currentPage >= 1}">
					<li class="page-number"><a href="javascript:void(0)" onclick="showAtRight('${pageContext.request.contextPath}/listCourseShow?keywords=${keywords}&currentPage=${currentPage+1}')"
						id = "pageTwo" name="pageTwo">${currentPage+1}</a>
					</li>
				</c:if>
				<c:if test="${totalCount-currentPage >= 2}">
					<li class="page-number"><a href="javascript:void(0)" onclick="showAtRight('${pageContext.request.contextPath}/listCourseShow?keywords=${keywords}&currentPage=${currentPage+2}')"
						id = "pageThree" name="pageThree">${currentPage+2}</a>
					</li>
				</c:if>
				<c:if test="${totalCount-currentPage >= 3}">
					<li class="page-number"><a href="javascript:void(0)" onclick="showAtRight('${pageContext.request.contextPath}/listCourseShow?keywords=${keywords}&currentPage=${currentPage+3}')"
						id = "pageFour" name="pageFour">${currentPage+3}</a>
					</li>
				</c:if>
				<c:if test="${totalCount-currentPage >= 4}">
					<li class="page-number"><a href="javascript:void(0)" onclick="showAtRight('${pageContext.request.contextPath}/listCourseShow?keywords=${keywords}&currentPage=${currentPage+4}')"
						id = "pageFive" name="pageFive">${currentPage+4}</a>
					</li>
				</c:if>
				<c:if test="${totalCount-currentPage >= 5}">
					<li class="page-number"><a href="javascript:void(0)" onclick="showAtRight('${pageContext.request.contextPath}/listCourseShow?keywords=${keywords}&currentPage=${currentPage+5}')"
						id = "pageSix" name="pageSix">${currentPage+5}</a>
					</li>
				</c:if>
				<c:if test="${totalCount-currentPage >= 6}">
					<li class="page-number"><a href="javascript:void(0)" onclick="showAtRight('${pageContext.request.contextPath}/listCourseShow?keywords=${keywords}&currentPage=${currentPage+6}')"
						id = "pageSeven" name="pageSeven">${currentPage+6}</a>
					</li>
				</c:if>

				<c:if test="${currentPage < totalCount}">
					<li class="pgNext"><a href="javascript:void(0)" onclick="showAtRight('${pageContext.request.contextPath}/listCourseShow?keywords=${keywords}&currentPage=${currentPage+1}')" id="downPage" name="downPage">下一页</a>
					</li>
					<li class="pgNext"><a href="javascript:void(0)" onclick="showAtRight('${pageContext.request.contextPath}/listCourseShow?keywords=${keywords}&currentPage=${totalCount}')"
						id = "pageEnd" name="pageEnd">末页</a>
					</li>
				</c:if>
				<li class="thpoint pagetotal" style="margin-top:3px;">共${totalCount}页
				</li>
				<li class="thpoint pagenow">当前<input type="text"
					value="${currentPage}" maxlength="6" id="gotoval"
					style="width:40px; height:20px;margin-top:-3px;padding-top:2px;padding-left:10px;">页
				</li>
				<li class="pgNext go"><a href="javascript:void(0);" id="btnOK" name="btnOk">确定</a>
				</li>
			</ul>
		</div>
	</body>
</html>
