<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head lang="zh-CN">
<base href="<%=basePath%>">
<meta charset="utf-8">
<!-- 初始网页宽度为设置屏幕宽度，缩放级别为1.0，禁止用户缩放-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">

<!-- 设置360等双内核的浏览器渲染模式 -->
<meta name="renderer" content="webkit">
<!-- 设置IE支持的最高模式 -->
<meta http-equiv="X-UA-Compatible" content="IE=Edge">

<!-- 禁止移动浏览器转码 -->
<meta http-equiv="Cache-Control" content="no-siteapp">
<!-- 网站标志 -->
<!-- <link rel="icon" type="image/png" href="favicon.png"> -->

<title>OSYS</title>
<!-- 网站描述 -->
<meta name="description"
	content="Yun+是一个完全响应式的后台主题UI框架，基于Boostrap CSS框架，jQuery框架等各种开源前端框架开发的HTML5+CSS3前端主题UI框架，提供各种强大的常用UI组件，您可以基于此框架应用于您的网站开发，如网站后台，会员中心，论坛，CMS等等。">
<!-- 网站SEO关键词 -->
<meta name="keywords"
	content="Yun+UI,云+主题,云加后台主题UI,响应式的后台主题,Boostrap主题框架">

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
	href="${pageContext.request.contextPath}/static/css/main/mycss.css"
	rel="stylesheet">
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
				action="${pageContext.request.contextPath}/main/listVideoShowV3">
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
									<small class="pull-right">23小时前</small> <strong>风姐</strong> 爱上
									<strong>小马哥啦！</strong>. <br> <small class="text-muted">2天前
										2:30 上午 - 11.06.2014</small>
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
					data-toggle="dropdown" href="index.html#"> <i
						class="fa fa-bell"></i> <span class="label label-primary">8</span>
				</a>
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
	</div>
	<!-- 右侧顶部导航div 结束 -->

	<div class="main" id="main" style="margin-top: 70px; margin-left: 50px; margin-bottom: 400px">
		<c:forEach var="data" items="${questionList}">
			<div class="ques-answer">
				<div class="tag-img">
					<a href="javascript:void(0)" target="_blank"> <img
						height="40px"
						src="${pageContext.request.contextPath}/${data.user.photo }"
						title="${data.user.username }"></img>
					</a>
				</div>
				<div class="from-tag">
					来自<label style="color: green; font-size: 15px">&nbsp&nbsp&nbsp${data.user.username
						}&nbsp&nbsp&nbsp</label> <label style="color: gray; font-size: 12px">&nbsp&nbsp&nbsp<fmt:formatDate
							value="${data.question.questiontime }" type="both"
							pattern="yyyy-MM-dd HH:mm" />
					</label>
				</div>
				<div class="question-content rich-text aimgPreview"
					style="font-size: 20px !improtant">
					${data.question.questioncontent }</div>

				<c:if test="${data.answer ne null}">
					<div class="answer-con first" data-answer-id="233497"
						id="answer-con">
						<div class="user">
							<span class="signature">最近回答：</span>
						</div>
						<div class="answer-content rich-text aimgPreview">${data.answer.answercontent
							}</div>
					</div>
				</c:if>
				<div>
					<a
						href="${pageContext.request.contextPath}/main/showAnswerList?id=${data.question.questionid}"
						target="_blank">点击查看更多...</a>
				</div>
			</div>
		</c:forEach>
		<div style="margin-top: 20px">
			<label style="color: blue; font-size: 20px">好不容易来一趟？？是不是要留下点什么，把你的问题留下吧</label>
		</div>
		<div class="wd-top-slogan">
			<button id="showSendArea">我要提问</button>
		</div>
		<div id="showSend" style="display: none">
			<div>
				<script id="editor" type="text/plain"
					style="height:300px;"></script>
			</div>

			<div class="note-send-button">
				<p class="panel_editor_btn" id="editorBtn" style="margin-top: 10px">
					<button id="btnPostMsg" class="btn btn-primary">发表</button>
				</p>
			</div>
		</div>
	</div>

	<div id="page-nav"
		style="width:100%; float:left; margin-bottom: 100px; margin-top:50px">
		<ul class="pages" id="pageNav" tag-current="${currentPage}"
			tag-total="${totalCount}">
			<c:if test="${currentPage > 1}">
				<li class="pgNext"><a
					href="${pageContext.request.contextPath}/main/showQuestionList?keywords=${keywords}&currentPage=1"
					id="pageHome" name="pageHome">首页</a></li>
				<li class="pgNext"><a
					href="${pageContext.request.contextPath}/main/showQuestionList?keywords=${keywords}&currentPage=${currentPage-1}"
					id="upPage" name="upPage">上一页</a></li>
			</c:if>

			<c:if test="${totalCount-currentPage >= 0}">
				<li class="page-number pgCurrent"><a
					href="main/showQuestionList?keywords=${keywords}&currentPage=${currentPage}"
					id="pageFirst" name="pageFirst">${currentPage}</a></li>
			</c:if>
			<c:if test="${totalCount-currentPage >= 1}">
				<li class="page-number"><a
					href="${pageContext.request.contextPath}/main/showQuestionList?keywords=${keywords}&currentPage=${currentPage+1}"
					id="pageTwo" name="pageTwo">${currentPage+1}</a></li>
			</c:if>
			<c:if test="${totalCount-currentPage >= 2}">
				<li class="page-number"><a
					href="${pageContext.request.contextPath}/main/showQuestionList?keywords=${keywords}&currentPage=${currentPage+2}"
					id="pageThree" name="pageThree">${currentPage+2}</a></li>
			</c:if>
			<c:if test="${totalCount-currentPage >= 3}">
				<li class="page-number"><a
					href="${pageContext.request.contextPath}/main/showQuestionList?keywords=${keywords}&currentPage=${currentPage+3}"
					id="pageFour" name="pageFour">${currentPage+3}</a></li>
			</c:if>
			<c:if test="${totalCount-currentPage >= 4}">
				<li class="page-number"><a
					href="${pageContext.request.contextPath}/main/showQuestionList?keywords=${keywords}&currentPage=${currentPage+4}"
					id="pageFive" name="pageFive">${currentPage+4}</a></li>
			</c:if>
			<c:if test="${totalCount-currentPage >= 5}">
				<li class="page-number"><a
					href="${pageContext.request.contextPath}/main/showQuestionList?keywords=${keywords}&currentPage=${currentPage+5}"
					id="pageSix" name="pageSix">${currentPage+5}</a></li>
			</c:if>
			<c:if test="${totalCount-currentPage >= 6}">
				<li class="page-number"><a
					href="${pageContext.request.contextPath}/main/showQuestionList?keywords=${keywords}&currentPage=${currentPage+6}"
					id="pageSeven" name="pageSeven">${currentPage+6}</a></li>
			</c:if>

			<c:if test="${currentPage < totalCount}">
				<li class="pgNext"><a
					href="${pageContext.request.contextPath}/main/showQuestionList?keywords=${keywords}&currentPage=${currentPage+1}"
					id="downPage" name="downPage">下一页</a></li>
				<li class="pgNext"><a
					href="${pageContext.request.contextPath}/main/showQuestionList?keywords=${keywords}&currentPage=${totalCount}"
					id="pageEnd" name="pageEnd">末页</a></li>
			</c:if>
			<li class="thpoint pagetotal" style="margin-top:3px;">共${totalCount}页
			</li>
			<li class="thpoint pagenow">当前<input type="text"
				value="${currentPage}" maxlength="6" id="gotoval"
				style="width:40px; height:20px;margin-top:-3px;padding-top:2px;padding-left:10px;">页
			</li>
			<li class="pgNext go"><a href="javascript:void(0);" id="btnOK"
				name="btnOk">确定</a></li>
		</ul>
	</div>
	<jsp:include page="/static/footer.html" flush="true"/>
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

	<script
		src="${pageContext.request.contextPath}/static/js/main/discussIndex.js"></script>

	<script type="text/javascript" charset="utf-8"
		src="${pageContext.request.contextPath}/static/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="${pageContext.request.contextPath}/static/ueditor.all.min.js">
		
	</script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8"
		src="${pageContext.request.contextPath}/static/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor');
	</script>
</body>
</html>