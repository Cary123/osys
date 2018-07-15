<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
     <form role="form"  id="uploadVideoForm" enctype="multipart/form-data">
     <div class="form-group">
			<label>请选择对应的课程</label>
			<button type="button" class="btn btn-primary" onclick="showBookListv2()">课程选择</button>
			<select id="bookList" width="400px" name="bookList" onchange="showExistChapterListv2()"
				class="selectpicker show-tick form-control" data-live-search="false">
				<option>--</option>
			</select>
	 </div>
	 
     <div class="form-group">
       <label>请选择本课程章节</label>
     </div>
     <div class="form-group">
        <select id="chapterList" onchange="showExistSectionList()" name="chapterList" class="selectpicker show-tick form-control" data-live-search="false">
          <option>--</option>
        </select>
     </div>
     <div class="form-group">
       <label for="sectorId">当前章号：</label> <input type="number"
				class="form-control" id="chapterId" name="chapterId" readonly="readonly"
				placeholder="请输入节号">
     </div>
     <div class="form-group">
			<label>对应章的节列表如下</label>
			<ul class="list-group" id="sectionList">

			</ul>
	 </div>
	 
	 <div class="form-group">
			<label style="color:blue">继续添加节</label>
	 </div>
	 
	 <div class="form-group">
			<label for="sectorNameId">节号</label> <input type="number"
				class="form-control" id="sectorNameId" name="sectorNameId"
				placeholder="请输入节号">
		</div>
		<div class="form-group">
			<label for="sectorName">节名</label> <input type="text" class="form-control"
				id="sectorName" name="sectorName" placeholder="请输入节名">
		</div>
	
     <div class="form-group">
       <label for="inputfile">请上传该节PDF</label>
       <input type="file" id="file" name="file">
     </div>
   </form>
    <button class="btn btn-primary" onclick="uploadVedio()">提交</button>
  </body>
</html>
