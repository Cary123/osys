function deleteCourse(bookid) {
	var xmlHttp;
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlHttp=new XMLHttpRequest();	//创建 XMLHttpRequest对象
	}
	else {
		// code for IE6, IE5
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlHttp.onreadystatechange=function() {		
		//onreadystatechange — 当readystate变化时调用后面的方法
		
		if (xmlHttp.readyState == 4) {
			//xmlHttp.readyState == 4	——	finished downloading response
			
			if (xmlHttp.status == 200) {
				if(xmlHttp.responseText = "success"){
					  alert("删除成功");
					}else{
					  alert("删除失败");
					}
			}
			//错误状态处理
			else if (xmlHttp.status == 404){
				alert("出错了☹   （错误代码：404 Not Found），……！"); 
				/* 对404的处理 */
				return;
			}
			else if (xmlHttp.status == 403) {  
				alert("出错了☹   （错误代码：403 Forbidden），……"); 
				/* 对403的处理  */ 
				return;
	        }
			else {
				alert("出错了☹   （错误代码：" + request.status); 
				/* 对出现了其他错误代码所示错误的处理   */
				return;
			}   
		} 
            
	  }
	
	//把请求发送到服务器上的指定文件（url指向的文件）进行处理
	xmlHttp.open("GET", "deleteCourse?id="+bookid, true);		//true表示异步处理
	xmlHttp.send();
   }

function uploadImage() {
    var imgPath = $("#file").val();
    if (imgPath == "") {
        alert("请选择上传图片！");
        return;
    }
    var strExtension = imgPath.substr(imgPath.lastIndexOf('.') + 1);
    if (strExtension != 'jpg' && strExtension != 'gif'
    && strExtension != 'png' && strExtension != 'bmp') {
        alert("请选择图片文件");
        return;
    }
      var formData = new FormData($("#uploadForm")[0]);
      $.ajax({ 
         async: true,
         url : "uploadFile",  
         type : 'POST',  
         data : formData,  
         processData : false,  //必须false才会避开jQuery对 formdata 的默认处理   
         contentType : false,  //必须false才会自动加上正确的Content-Type 
         success : function(result) { 
             if(result.returnCode == 1){
                alert("添加成功");
              }else{
                alert("添加失败");
              }
            },  
         error : function(result) {  
             alert("网络出问题了!");
          }  
       });  
  }

 function progressFunction(evt) {

    var progressBar = document.getElementById("progressBar");

    var percentageDiv = document.getElementById("percentage");

    if (evt.lengthComputable) {

        progressBar.max = evt.total;

        progressBar.value = evt.loaded;

        percentageDiv.innerHTML = Math.round(evt.loaded / evt.total * 100) + "%";
    }
} 
 
 function modifyImage() {
		var formData = new FormData($("#uploadForm")[0]);
		$.ajax({
			async : true,
			url : "editCourse",
			type : 'POST',
			data : formData,
			processData : false, //必须false才会避开jQuery对 formdata 的默认处理   
			contentType : false, //必须false才会自动加上正确的Content-Type 
			success : function(result) {
				if (result.returnCode == 1) {
					alert("修改成功");
					$("#courseName").val("");
					$("#courseDescribe").val("");
					$("#courseCreator").val("");
					$("#file").val("");
				} else {
					alert("修改失败");
				}
			},
			error : function(result) {
				alert("网络出问题了!");
			}
		});
	}

	function executeScript(html) {

		var reg = /<script[^>]*>([^\x00]+)$/i;
		//对整段HTML片段按<\/script>拆分
		var htmlBlock = html.split("<\/script>");
		for ( var i in htmlBlock) {
			var blocks;//匹配正则表达式的内容数组，blocks[1]就是真正的一段脚本内容，因为前面reg定义我们用了括号进行了捕获分组
			if (blocks = htmlBlock[i].match(reg)) {
				//清除可能存在的注释标记，对于注释结尾   可以忽略处理，eval一样能正常工作
				var code = blocks[1].replace(/<!--/, '');
				try {
					eval(code) //执行脚本
				} catch (e) {
				}
			}
		}
	}
	
	function SearchBook()
	{
		var keyWords = $("#top-search").val();
		showAtRight("editCourseShow?keywords="+keyWords);
	}

	/*
	 * 利用div实现左边点击右边显示的效果（以id="content"的div进行内容展示）
	 * 注意：
	 *   ①：js获取网页的地址，是根据当前网页来相对获取的，不会识别根目录；
	 *   ②：如果右边加载的内容显示页里面有css，必须放在主页（即例中的index.jsp）才起作用
	 *   （如果单纯的两个页面之间include，子页面的css和js在子页面是可以执行的。 主页面也可以调用子页面的js。但这时要考虑页面中js和渲染的先后顺序 ）
	 */
	function showAtRight(url) {
		var xmlHttp;

		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlHttp = new XMLHttpRequest(); //创建 XMLHttpRequest对象
		} else {
			// code for IE6, IE5
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlHttp.onreadystatechange = function() {
			//onreadystatechange — 当readystate变化时调用后面的方法

			if (xmlHttp.readyState == 4) {
				//xmlHttp.readyState == 4	——	finished downloading response

				if (xmlHttp.status == 200) {
					//xmlHttp.status == 200		——	服务器反馈正常			

					document.getElementById("mainBody").innerHTML = xmlHttp.responseText;
					executeScript(xmlHttp.responseText); //执行从服务器返回的页面内容里包含的JavaScript函数
				}
				//错误状态处理
				else if (xmlHttp.status == 404) {
					alert("出错了☹   （错误代码：404 Not Found），……！");
					/* 对404的处理 */
					return;
				} else if (xmlHttp.status == 403) {
					alert("出错了☹   （错误代码：403 Forbidden），……");
					/* 对403的处理  */
					return;
				} else {
					alert("出错了☹   （错误代码：" + request.status + "），……");
					/* 对出现了其他错误代码所示错误的处理   */
					return;
				}
			}

		}

		//把请求发送到服务器上的指定文件（url指向的文件）进行处理
		xmlHttp.open("GET", url, true); //true表示异步处理
		xmlHttp.send();
	}