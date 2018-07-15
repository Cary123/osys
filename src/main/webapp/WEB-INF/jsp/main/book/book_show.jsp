<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 引入Bootstrap CSS框架 awesome字体-->
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap/3.3.4/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/fonts/font-awesome/css/font-awesome.css"
	rel="stylesheet">

<!-- CSS动画框架 -->
<link href="${pageContext.request.contextPath}/static/css/animate.css"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath}/static/css/plugins/codemirror/codemirror.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/css/plugins/codemirror/ambiance.css"
	rel="stylesheet">
<!-- Yun+ UI css主文件 -->
<link href="${pageContext.request.contextPath}/static/css/yuntheme.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/css/main/index.css"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath}/static/css/main/mycss.css"
	rel="stylesheet">

<!-- 引入主要jQuery 等js框架 -->
<script
	src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/bootstrap/3.3.4/bootstrap.min.js"></script>

<script
	src="${pageContext.request.contextPath}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<!-- Custom and plugin javascript -->
<script src="${pageContext.request.contextPath}/static/js/inspinia.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/plugins/pace/pace.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/pdfobject.js"></script>

<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/static/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/static/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/static/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/static/js/main/bookShow.js"></script>
<style type="text/css">
.nav.navbar-top-links .linkCss {
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

#left {
	height: 100%;
	width: 20%;
	background: #333333;
	float: left;
}

#middle {
	height: 1000px;
	width: 60%;
	background: white;
	margin-left: 1%;
	float: left;
}

#right {
	height: 100%;
	width: 18%;
	background: white;
	float: left;
	margin-left: 1%;
}
</style>
</head>

<body>
	<nav style="background-color: #222222"
		class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<ul class="nav navbar-top-links navbar-left">
			<li role="presentation">
				<div
					style="width: 150px; height:60px; text-align:center; margin:0 auto">
					<a class="linkCss" href="${pageContext.request.contextPath}/index">在线课程
					</a>
				</div></li>
			<li role="presentation"><div
					style="width: 150px; height:60px; text-align:center; margin:0 auto">
					<a class="linkCss"
						href="${pageContext.request.contextPath}/main/video">视频精讲 </a>
				</div></li>
			<li role="presentation"><div
					style="width: 150px; height:60px; text-align:center; margin:0 auto">
					<a class="linkCss"
						href="${pageContext.request.contextPath}/main/discuss">讨论区</a>
				</div></li>
		</ul>

		<form class="navbar-form navbar-left" role="search"
			action="${pageContext.request.contextPath}/main/listBookShowV3">
			<div class="form-group">
				<label class="sr-only"></label> <input id="txtSearch"
					style="width:320px" type="text" class="form-control"
					placeholder="搜索" value="${keywords}" name="keywords" />
			</div>

			<button id="btnKeyWord" onclick="ListBookShow(1)"
				class="btn btn-primary navbar-btn">搜索</button>
		</form>


		<ul class="nav navbar-top-links navbar-right">
			<li><div>
					<a href="${pageContext.request.contextPath}/userInfoShow"><span><img class="img-circle"
							height="35px"
							src="${pageContext.request.contextPath}/${sessionScope.currentUser.photo}"
							alt="image"> </span> </a>
				</div></li>
			<li class="dropdown"><a class="dropdown-toggle count-info"
				style="" data-toggle="dropdown" href="#"> <i
					class="fa fa-envelope"></i> <span class="label label-warning">16</span>
			</a>

				<ul class="dropdown-menu dropdown-messages">
					<li>
						<div class="dropdown-messages-box">
							<a class="pull-left" href="profile.html"> <img
								class="img-circle"
								src="${pageContext.request.contextPath}/img/a7.jpg" alt="image">
							</a>
							<div class="media-body">
								<small class="pull-right">46h前</small> <strong>国民老公</strong>又在微博放料啦，某某女演员……<br>
								<small class="text-muted">3 前 7:58 下午 - 10.06.2014</small>
							</div>
						</div>
					</li>
					<li class="divider"></li>
					<li>
						<div class="dropdown-messages-box">
							<a href="profile.html" class="pull-left"> <img alt="image"
								class="img-circle"
								src="${pageContext.request.contextPath}/img/a4.jpg"> </a>
							<div class="media-body ">
								<small class="pull-right text-navy">5小时前</small> <strong>股票大跌</strong>
								小马哥不再是首富了。 <strong>———来自财经网</strong>. <br> <small
									class="text-muted">昨天 1:21 下午 - 11.06.2014</small>
							</div>
						</div>
					</li>
					<li class="divider"></li>
					<li>
						<div class="dropdown-messages-box">
							<a href="profile.html" class="pull-left"> <img alt="image"
								class="img-circle"
								src="${pageContext.request.contextPath}/${sessionScope.currentUser.photo}">
							</a>
							<div class="media-body ">
								<small class="pull-right">23小时前</small> <strong>风姐</strong> 爱上 <strong>小马哥啦！</strong>.
								<br> <small class="text-muted">2天前 2:30 上午 -
									11.06.2014</small>
							</div>
						</div>
					</li>
					<li class="divider"></li>
					<li>
						<div class="text-center link-block">
							<a href="mailbox.html"> <i class="fa fa-envelope"></i> <strong>查看全部消息</strong>
							</a>
						</div>
					</li>
				</ul>
			</li>
			<li class="dropdown"><a class="dropdown-toggle count-info"
				data-toggle="dropdown" href="index.html#"> <i class="fa fa-bell"></i>
					<span class="label label-primary">8</span> </a>
				<ul class="dropdown-menu dropdown-alerts">
					<li><a href="mailbox.html">
							<div>
								<i class="fa fa-envelope fa-fw"></i> 你有8条未读消息 <span
									class="pull-right text-muted small">4 分钟前</span>
							</div> </a>
					</li>
					<li class="divider"></li>
					<li><a href="profile.html">
							<div>
								<i class="fa fa-qq fa-fw"></i> 3条新回复 <span
									class="pull-right text-muted small">12 分钟前</span>
							</div> </a>
					</li>
					<li class="divider"></li>
					<li><a href="grid_options.html">
							<div>
								<i class="fa fa-upload fa-fw"></i> 服务器重启 <span
									class="pull-right text-muted small">4 分钟前</span>
							</div> </a>
					</li>
					<li class="divider"></li>
					<li>
						<div class="text-center link-block">
							<a href="notifications.html"> <strong>查看全部提醒</strong> <i
								class="fa fa-angle-right"></i> </a>
						</div>
					</li>
				</ul>
			</li>
			<li><a href="${pageContext.request.contextPath}/logout"> <i
					class="fa fa-sign-out"></i> 退出 </a>
			</li>
		</ul>
	</nav>

	<div id="main"
		style="margin-top: 80px; background-color: gray; height: 1000px">
		<div id="left">
			<div class="sidebar-collapse">
				<ul class="nav metismenu" id="side-menu" style="font-size: 16px">
					<c:forEach var="chapter" items="${bookDetail.chapters }">
						<li class=""><a href="${pageContext.request.contextPath}/#">
								<i class="fa fa-th-large"> </i> <span class="nav-tabel">${chapter.chapter.chaptername
									}</span> <span class="fa arrow"></span> </a>
							<ul class="nav nav-second-level">
								<li><a
									href="${pageContext.request.contextPath}/main/videoShow?chapterId=${chapter.chapter.chapterid}&bookId=${chapter.chapter.bookid}"><label
										style="color: red">(进入视频)</label> </a>
								</li>
								<c:forEach var="sector" items="${chapter.sectors }">
									<li><a href="javascript:void(0)"
										onclick="ChangePDF('${pageContext.request.contextPath}/${sector.pdfurl}')">${sector.sectorname
											}</a>
									</li>
								</c:forEach>
							</ul>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div id="middle">
			<embed class="pdfobject"
				src="${pageContext.request.contextPath}/${bookDetail.chapters[0].sectors[0].pdfurl}"
				type="application/pdf"
				style="overflow: auto; width: 100%; height: 100%;"
				internalinstanceid="22" title="">
		</div>
		<div id="right">
			<div id="bookDescript" style="text-align:center;">
				<img alt="xxx" width="100px" src="${bookDetail.book.bookimage}">
				<p>
					<label id="bookNote" data-bookid="${bookDetail.book.bookid}"
						style="font-size: 20px; color: black">${bookDetail.book.bookname}</label>
				</p>
				<p>
					<label style="font-size: 10px; color: blue">${bookDetail.book.bookcreater}</label>
				</p>
				<p>
					<label style="font-size: 10px; color: gray">${bookDetail.book.bookdescript}</label>
				</p>
			</div>
		</div>
	</div>
	<div class="ans_num"></div>
	<div style="margin-left: 50px; margin-bottom: 400px">
		<div class="wd-top-slogan">
			<button id="showSendArea">我要评论</button>
		</div>
		<div id="showSend" style="display: none">
			<div>
				<script id="editor" type="text/plain"
					style="height:100px;"></script>
			</div>

			<div class="note-send-button">
				<p class="panel_editor_btn" id="editorBtn" style="margin-top: 10px">
					<button id="btnPostMsg" class="btn btn-primary">发表</button>
				</p>
			</div>
		</div>
		<div class="ans_num" id="answerCount" data-content="${count}">${count}次回答</div>

		<div id="bookNoteList">
			<c:forEach var="data" items="${bookNoteList}">
				<div class="ques-answer">
					<div class="tag-img">
						<a href="javascript:void(0)" target="_blank"> <img
							height="40px"
							src="${pageContext.request.contextPath}/${data.user.photo }"
							title="${data.user.username }"></img> </a>
					</div>
					<div class="from-tag">
						来自<label style="color: green; font-size: 15px">&nbsp&nbsp&nbsp${data.user.username
							}&nbsp&nbsp&nbsp</label> <label style="color: gray; font-size: 12px">&nbsp&nbsp&nbsp<fmt:formatDate
								value="${data.booknote.notetime }" type="both"
								pattern="yyyy-MM-dd HH:mm" /> </label>
					</div>
					<div class="question-content rich-text aimgPreview">
						${data.booknote.notecontent }</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<jsp:include page="/static/footer.html" flush="true"/>
	<script type="text/javascript">
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor');
	</script>
	<script type="text/javascript">
		function ChangePDF(pdf) {
			PDFObject.embed(pdf, "#middle");
		}
	</script>
</body>
</html>
