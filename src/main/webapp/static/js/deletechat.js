function deleteChat(noteid){
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
				alert("出错了☹   （错误代码" ); 
				/* 对出现了其他错误代码所示错误的处理   */
				return;
			}   
		} 
            
	  }
	
	//把请求发送到服务器上的指定文件（url指向的文件）进行处理
	xmlHttp.open("GET", "deleteChat?id="+noteid, true);		//true表示异步处理
	xmlHttp.send();
}

function deleteSector(sectorid){
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
	xmlHttp.open("GET", "deleteSector?id="+sectorid, true);		//true表示异步处理
	xmlHttp.send();
}