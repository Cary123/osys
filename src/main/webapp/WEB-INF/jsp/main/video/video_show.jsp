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
<link
	href="${pageContext.request.contextPath}/static/css/video-js.min.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/video.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<!-- Custom and plugin javascript -->
<script src="${pageContext.request.contextPath}/static/js/inspinia.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/plugins/pace/pace.min.js"></script>

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
	src="${pageContext.request.contextPath}/static/js/main/videoShow.js"></script>

</head>

<body>
	<div id="header" style="height: 64px">
		<nav style="background-color: #222222"
			class="navbar navbar-fixed-top navbar-inverse" role="navigation">
			<ul class="nav navbar-top-links navbar-left">
				<li role="presentation">
					<div
						style="width: 150px; height:60px; text-align:center; margin:0 auto">
						<a class="linkCss" href="${pageContext.request.contextPath}/index">在线课程
						</a>
					</div>
				</li>
				<li role="presentation"><div
						style="width: 150px; height:60px; text-align:center; margin:0 auto">
						<a class="linkCss"
							href="${pageContext.request.contextPath}/main/video">视频精讲 </a>
					</div>
				</li>
				<li role="presentation"><div
						style="width: 150px; height:60px; text-align:center; margin:0 auto">
						<a class="linkCss"
							href="${pageContext.request.contextPath}/main/discuss">讨论区</a>
					</div>
				</li>
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
					</div>
				</li>
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
							</div></li>
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
							</div></li>
						<li class="divider"></li>
						<li>
							<div class="dropdown-messages-box">
								<a href="profile.html" class="pull-left"> <img alt="image"
									class="img-circle"
									src="${pageContext.request.contextPath}/${sessionScope.currentUser.photo}">
								</a>
								<div class="media-body ">
									<small class="pull-right">23小时前</small> <strong>风姐</strong> 爱上
									<strong>小马哥啦！</strong>. <br> <small class="text-muted">2天前
										2:30 上午 - 11.06.2014</small>
								</div>
							</div></li>
						<li class="divider"></li>
						<li>
							<div class="text-center link-block">
								<a href="mailbox.html"> <i class="fa fa-envelope"></i> <strong>查看全部消息</strong>
								</a>
							</div></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle count-info"
					data-toggle="dropdown" href="index.html#"> <i
						class="fa fa-bell"></i> <span class="label label-primary">8</span>
				</a>
					<ul class="dropdown-menu dropdown-alerts">
						<li><a href="mailbox.html">
								<div>
									<i class="fa fa-envelope fa-fw"></i> 你有8条未读消息 <span
										class="pull-right text-muted small">4 分钟前</span>
								</div> </a></li>
						<li class="divider"></li>
						<li><a href="profile.html">
								<div>
									<i class="fa fa-qq fa-fw"></i> 3条新回复 <span
										class="pull-right text-muted small">12 分钟前</span>
								</div> </a></li>
						<li class="divider"></li>
						<li><a href="grid_options.html">
								<div>
									<i class="fa fa-upload fa-fw"></i> 服务器重启 <span
										class="pull-right text-muted small">4 分钟前</span>
								</div> </a></li>
						<li class="divider"></li>
						<li>
							<div class="text-center link-block">
								<a href="notifications.html"> <strong>查看全部提醒</strong> <i
									class="fa fa-angle-right"></i> </a>
							</div></li>
					</ul></li>
				<li><a href="${pageContext.request.contextPath}/logout"> <i
						class="fa fa-sign-out"></i> 退出 </a></li>
			</ul>
		</nav>
	</div>

	<div id="studyMain">
		<div class="video" style="width: 80%; float:left">
			<video width="1200px" id="my-player" class="video-js" controls
				preload="auto" poster="//vjs.zencdn.net/v/oceans.png"
				data-setup='{}'>
				<source id="mp4-video"
					src="${pageContext.request.contextPath}/${chapter.videourl }"
					type="video/mp4"></source>
				<source id="webm-video"
					src="${pageContext.request.contextPath}/${chapter.videourl }"
					type="video/webm"></source>
				<source id="ogg-video"
					src="${pageContext.request.contextPath}/${chapter.videourl }"
					type="video/ogg"></source>
				<p class="vjs-no-js">
					To view this video please enable JavaScript, and consider upgrading
					to a web browser that <a
						href="http://videojs.com/html5-video-support/" target="_blank">
						supports HTML5 video </a>
				</p>
			</video>
		</div>
		<div class="video-list"
			style="width: 20%; float:left; height: 675px; background-color: #222222">
			<div class="nano-content" tabindex="0" style="right: -17px;">
				<h3 style="margin-top: 20px; text-align: center">${book.bookname}</h3>
				<ol id="video-list">
					<c:forEach var="chapterSingle" items="${chapterList}">
						<c:if test="${chapter.chapterid ne chapterSingle.chapterid}">
							<li style="margin-top: 10px;"><a
								href="${pageContext.request.contextPath}/main/videoShow?chapterId=${chapterSingle.chapterid}&bookId=${chapterSingle.bookid}"><span
									style="color: white; font-size: 16px;">${chapterSingle.chaptername}</span>
							</a></li>
						</c:if>
						<c:if test="${chapter.chapterid eq chapterSingle.chapterid}">
							<li id="videoNote" data-chapterid="${chapterSingle.chapterid}"
								style="margin-top: 10px;"><a
								href="${pageContext.request.contextPath}/main/videoShow?chapterId=${chapterSingle.chapterid}&bookId=${chapterSingle.bookid}"><span
									style="color: red; font-size: 16px;">${chapterSingle.chaptername}</span>
							</a></li>
						</c:if>
					</c:forEach>
				</ol>
			</div>
		</div>
	</div>
	<div class="wd-top-slogan">
		<button id="showSendArea">我要评论</button>
	</div>
	<div style="margin-left: 50px">
		<div id="showSend" style="display: none">
			<div style="margin-top: 20px">
				<label style="color: blue; font-size: 20px">我来评论：</label>
			</div>

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

		<div id="videoNoteList" style="margin-bottom: 400px">
			<c:forEach var="data" items="${videoNoteList}">
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
								value="${data.videonote.notetime }" type="both"
								pattern="yyyy-MM-dd HH:mm" /> </label>
					</div>
					<div class="question-content rich-text aimgPreview">
						${data.videonote.notecontent }</div>
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
		//打开自动播放
		var myPlayer = videojs('my-player');
		videojs("my-player").ready(function() {
			var myPlayer = this;
			myPlayer.play();
		});
	</script>
</body>
</html>
