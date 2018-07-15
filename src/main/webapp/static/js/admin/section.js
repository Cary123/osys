function showBookListv2(){
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
                     $("#chapterList").empty();
                     $("#sectionList").empty();
                     var i=0;
                     for (i=0;i<courses.length;i++)
                     {     	 
                        $("#bookList").append("<option value='"+courses[i].bookid+"'>"+courses[i].bookid+"("+courses[i].bookname+")"+"</option>"); 
                     }
                     showExistChapterListv2();
                    },  
                 error : function(result) {  
                     alert("网络出问题了!");
                  }  
               });  
         }

function showExistChapterListv2(){
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
          	    	$("#sectionList").empty();
	                  for (i=0;i<chapters.length;i++)
	                  {
	                  	 $("#chapterList").append("<option data-chapter='"+chapters[i].chapterid+"' value='"+chapters[i].chapternameid+"'>"+chapters[i].chaptername+"</option>");
	                  }
	                  showExistSectionList();
          	    }
            },
          error : function() {  
          	 $('#tips').css({"color":"red"});
			     $('#tips').html('服务器异常');
               return false;  
           }   
        });
	  }

function showExistSectionList(){
	 var bookId = $('#bookId option:selected').val();
	 var chapterId = $('#chapterList option:selected').attr('data-chapter');
	  $.ajax({  
           type: 'POST',  
           url :"showExistSectionList",
           dataType: 'json',
           //contentType:'application/json;charset=UTF-8',
           contentType: "application/x-www-form-urlencoded",
           data: {  
                 chapterId:chapterId
           },  
           success: function(data){ 
         	    if(data.returnCode == 1)
         	    {
         	    	var sectors = data.field.sectors;
         	    	$("#sectionList").empty();
	                  for (i=0;i<sectors.length;i++)
	                  {
	                	  if(i%2 == 0){
	                		  $("#sectionList").append("<li class='list-group-item-success' value='"+sectors[i].sectornameid+"'>"+sectors[i].sectorname+"</li>");
	                	  }else{
	                		  $("#sectionList").append("<li class='list-group-item-info' value='"+sectors[i].sectornameid+"'>"+sectors[i].sectorname+"</li>");
	                	  }
	                  }
                   var number=$("#sectionList li:last").val();
                   $("#chapterId").val(chapterId);
                   $("#sectorNameId").val(parseInt(number)+1);
         	    }
           },
         error : function() {  
         	 $('#tips').css({"color":"red"});
			     $('#tips').html('服务器异常');
              return false;  
          }   
       });
	  }

function uploadVedio() {
    var formData = new FormData($("#uploadVideoForm")[0]);
    $.ajax({ 
           async: true,
           url : "uploadVedio",  
           type : 'POST',  
           data : formData,  
           processData : false,  //必须false才会避开jQuery对 formdata 的默认处理   
           contentType : false,  //必须false才会自动加上正确的Content-Type 
           success : function(result) { 
               if(result.returnCode == 1){
                  alert("添加成功");
                  showExistSectionList();
                }else{
                  alert("添加失败");
                }
              },  
           error : function(result) {  
               alert("网络出问题了!");
            }  
         });  
    }

function modifySector(){
	 var formData = new FormData($("#uploadForm")[0]);
	    $.ajax({ 
	           async: true,
	           url : "modifySector",  
	           type : 'POST',  
	           data : formData,  
	           processData : false,  //必须false才会避开jQuery对 formdata 的默认处理   
	           contentType : false,  //必须false才会自动加上正确的Content-Type 
	           success : function(result) { 
	               if(result.returnCode == 1){
	                  alert("修改成功");
	                  showExistSectionList();
	                }else{
	                  alert("修改失败");
	                }
	              },  
	           error : function(result) {  
	               alert("网络出问题了!");
	            }  
	         });  
}

function deleteSector(sectorId)
{
	 $.ajax({ 
         url : "deleteSector",  
         type : 'POST',  
         data : {sectorId:sectorId},  
         dataType: "json",
         success : function(result) { 
             if(result.returnCode == 1){
                alert("删除成功");
              }else{
                alert("删除失败");
              }
            },  
         error : function(result) {  
             alert("网络出问题了!");
          }  
       });  
}

function showModifyBookListv2(){
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
			   showModifyChapterList();
		   },  
		   error : function(result) {  
			   alert("网络出问题了!");
		   }  
	   });  
}

function showModifyChapterList(){
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
         	    	$("#sectionList").empty();
	                  for (i=0;i<chapters.length;i++)
	                  {
	                  	 $("#chapterList").append("<option data-chapter='"+chapters[i].chapterid+"' value='"+chapters[i].chapternameid+"'>"+chapters[i].chaptername+"</option>");
	                  }
	                  showDeleteSectorList();
         	    }
           },
         error : function() {  
         	 $('#tips').css({"color":"red"});
			     $('#tips').html('服务器异常');
              return false;  
          }   
       });
}

function showDeleteSectorList(){
	  var chapterId = $('#chapterList option:selected').attr("data-chapter");
	
	  $.ajax({  
            type: 'POST',  
            url :"showDeleteSectorList",
            dataType: 'json',
            //contentType:'application/json;charset=UTF-8',
            contentType: "application/x-www-form-urlencoded",
            data: {  
            	chapterId:chapterId
            },  
            success: function(data){ 
          	    if(data.returnCode == 1)
          	    {
          	    	var sectors = data.field.sectors;
          	    	$("#sectorDeleteList").empty();
                      for (i=0;i<sectors.length;i++)
                      {  
                         if(i%2 == 0){
                      	   $("#sectorDeleteList").append("<tr bgcolor='#fce5cd'>"
                      		+"<td>"+sectors[i].sectorid+"</td>"
                      		+"<td>"+sectors[i].sectorname+"</td>" 
                      		+"<td>"+sectors[i].chapterid+"</td>"
                         		+"<td>"+sectors[i].videourl+"</td>" 
                         		+"<td>"+"<a href='javascript:void(0)' onclick='deletesector("+sectors[i].sectorid+")'><img src='static/image/ico_error.png'/> </a>"+"</td>"
                      	   +"<td>"+"<a href='showEditSector?sectorId="+sectors[i].sectorid+"'><img src='static/image/ico_ok.png'/> </a>"+"</td>"); 
                      	}else{
                      	   $("#sectorDeleteList").append("<tr bgcolor='#f4cccc'>"
 	                        		+"<td>"+sectors[i].sectorid+"</td>"
 	                        		+"<td>"+sectors[i].sectorname+"</td>" 
 	                        		+"<td>"+sectors[i].chapterid+"</td>"
 	                           		+"<td>"+sectors[i].pdfurl+"</td>" 
 	                           		+"<td>"+"<a href='javascript:void(0)' onclick='deletesector("+sectors[i].sectorid+")'><img src='static/image/ico_error.png'/> </a>"+"</td>"
                      	   		+"<td>"+"<a href='showEditSector?sectorId="+sectors[i].sectorid+"'><img src='static/image/ico_ok.png'/> </a>"+"</td>"); 
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