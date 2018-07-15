<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>jQuery File Upload Example</title>
<script src="static/js/jquery-2.1.1.js" ></script>
<script src="static/js/bootstrap/3.3.4/bootstrap.min.js" ></script>

<script src="static/js/jquery.ui.widget.js"></script>
<script src="static/js/jquery.iframe-transport.js"></script>
<script src="static/js/jquery.fileupload.js"></script>

<!-- bootstrap just to have good looking page -->
<link href="static/css/bootstrap/3.3.4/bootstrap.min.css"  rel="stylesheet">

<!-- we code these -->
<link href="static/css/dropzone.css" type="text/css" rel="stylesheet" />
