       function showBookList(){
               $.ajax({ 
                 async: true,
                 url : "getCourseIds",  
                 type : 'POST', 
                 dataType: 'json',
	             //contentType:'application/json;charset=UTF-8',
	             //contentType: "application/x-www-form-urlencoded",
                 processData : false,  //必须false才会避开jQuery对 formdata 的默认处理   
                 contentType : false,  //必须false才会自动加上正确的Content-Type 
                 success : function(data) { 
                     var courses = data.field.books;
                     $("#bookList").empty();
                     var i=0;
                     for (i=0;i<courses.length;i++)
                     {     	 
                        $("#bookList").append("<option value='"+courses[i].bookid+"'>"+courses[i].bookid+"("+courses[i].bookname+")"+"</option>"); 
                     }
                     showExistChapterList();
                    },  
                 error : function(result) {  
                     alert("网络出问题了!");
                  }  
               });  
         }
       
       function showModifyBookList(){
    	   $.ajax({ 
    		   async: true,
    		   url : "getCourseIds",  
    		   type : 'POST', 
    		   dataType: 'json',
    		   //contentType:'application/json;charset=UTF-8',
    		   //contentType: "application/x-www-form-urlencoded",
    		   processData : false,  //必须false才会避开jQuery对 formdata 的默认处理   
    		   contentType : false,  //必须false才会自动加上正确的Content-Type 
    		   success : function(data) { 
    			   var courses = data.field.books;
    			   $("#bookList").empty();
    			   var i=0;
    			   for (i=0;i<courses.length;i++)
    			   {     	 
    				   $("#bookList").append("<option value='"+courses[i].bookid+"'>"+courses[i].bookid+"("+courses[i].bookname+")"+"</option>"); 
    			   }
    			   showDeleteList();
    		   },  
    		   error : function(result) {  
    			   alert("网络出问题了!");
    		   }  
    	   });  
       }
      
      function showExistChapterList(){
    	  var bookId = $('#bookList option:selected').val();
    	  $.ajax({  
	              type: 'POST',  
	              url :"showExistChapterList",
	              dataType: 'json',
	              //contentType:'application/json;charset=UTF-8',
	              contentType: "application/x-www-form-urlencoded",
	              data: {  
	                    bookId:bookId
	              },  
	              success: function(data){ 
	            	    if(data.returnCode == 1)
	            	    {
	            	    	var chapters = data.field.chapters;
	            	    	$("#chapterList").empty();
	                        for (i=0;i<chapters.length;i++)
	                        {
	                        	if(i%2==0){
	                        		$("#chapterList").append("<li class='list-group-item-success' value='"+chapters[i].chapternameid+"'>"+chapters[i].chaptername+"</li>"); 
	                        	}else{
	                        		$("#chapterList").append("<li class='list-group-item-info' value='"+chapters[i].chapternameid+"'>"+chapters[i].chaptername+"</li>"); 
	                        	}
	                        }
	                        var number=$("#chapterList li:last").val();
	                        $("#bookId").val(bookId);
	                        $("#chapterNameId").val(parseInt(number)+1);
	            	    }
	              },
	            error : function() {  
	            	 $('#tips').css({"color":"red"});
				     $('#tips').html('服务器异常');
	                 return false;  
	             }   
	          });
    	  }
      
    function showDeleteList(){
    	  var bookId = $('#bookList option:selected').val();
    	  $.ajax({  
	              type: 'POST',  
	              url :"showDeleteList",
	              dataType: 'json',
	              //contentType:'application/json;charset=UTF-8',
	              contentType: "application/x-www-form-urlencoded",
	              data: {  
	                    bookId:bookId
	              },  
	              success: function(data){ 
	            	    if(data.returnCode == 1)
	            	    {
	            	    	var chapters = data.field.chapters;
	            	    	$("#chapterDeleteList").empty();
	                        for (i=0;i<chapters.length;i++)
	                        {  
	                           if(i%2 == 0){
	                        	   $("#chapterDeleteList").append("<tr bgcolor='#fce5cd'>"
	                        		+"<td>"+chapters[i].chapternameid+"</td>"
	                        		+"<td>"+chapters[i].chaptername+"</td>" 
	                        		+"<td>"+chapters[i].bookid+"</td>"
	                           		+"<td>"+chapters[i].videourl+"</td>" 
	                           		+"<td>"+"<a href='javascript:void(0)' onclick='deleteChapter("+chapters[i].chapterid+")'><img src='static/image/ico_error.png'/> </a>"+"</td>"
	                        	   +"<td>"+"<a href='showEditChapter?id="+chapters[i].chapterid+"'><img src='static/image/ico_ok.png'/> </a>"+"</td>"); 
	                        	}
	                           else{
	                        	   $("#chapterDeleteList").append("<tr bgcolor='#f4cccc'>"
	   	                        		+"<td>"+chapters[i].chapternameid+"</td>"
	   	                        		+"<td>"+chapters[i].chaptername+"</td>" 
	   	                        		+"<td>"+chapters[i].bookid+"</td>"
	   	                           		+"<td>"+chapters[i].videourl+"</td>" 
	   	                           		+"<td>"+"<a href='javascript:void(0)' onclick='deleteChapter("+chapters[i].chapterid+")'><img src='static/image/ico_error.png'/> </a>"+"</td>"
	                        	   		+"<td>"+"<a href='showEditChapter?id="+chapters[i].chapterid+"'><img src='static/image/ico_ok.png'/> </a>"+"</td>"); 
	                           }
	                        }
	            	    }
	              },
	            error : function() { 
	            	 alert("error");
	            	 $('#tips').css({"color":"red"});
				     $('#tips').html('服务器异常');
	                 return false;  
	             }   
	          });
      }
    
    function uploadPPTImage() {
        var formData = new FormData($("#uploadPPTForm")[0]);
        $.ajax({ 
               async: true,
               url : "addChapter",  
               type : 'POST',  
               data : formData,  
               processData : false,  //必须false才会避开jQuery对 formdata 的默认处理   
               contentType : false,  //必须false才会自动加上正确的Content-Type 
               success : function(result) { 
                   if(result.returnCode == 1){
                      alert("添加成功");
                      showExistChapterList();
                    }else{
                      alert("添加失败");
                    }
                  },  
               error : function(result) {  
                   alert("网络出问题了!");
                }  
             });  
        }
    
    function deleteChapter(chapterid){
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
						  showDeleteList();
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
		xmlHttp.open("GET", "deleteChapter?id="+chapterid, true);		//true表示异步处理
		xmlHttp.send();
	   }
    
    function uploadChapter() {
		var formData = new FormData($("#uploadForm")[0]);
		$.ajax({
			async : true,
			url : "editChapter",
			type : 'POST',
			data : formData,
			processData : false, //必须false才会避开jQuery对 formdata 的默认处理   
			contentType : false, //必须false才会自动加上正确的Content-Type 
			success : function(result) {
				if (result.returnCode == 1) {
					alert("修改成功");
				} else {
					alert("修改失败");
				}
			},
			error : function(result) {
				alert("网络出问题了!");
			}
		});
	}
