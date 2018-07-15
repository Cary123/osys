function addChat() {
          var formData = new FormData($("#chatForm")[0]);
          $.ajax({ 
                 async: true,
                 url : "addChat",  
                 type : 'POST',  
                 data : formData,  
                 processData : false,  //必须false才会避开jQuery对 formdata 的默认处理   
                 contentType : false,  //必须false才会自动加上正确的Content-Type 
                 success : function(result) { 
                     if(result.code == 1){
                        alert("添加成功");
                        $("#sectorId").val("");
                        $("#noteDes").val("");
                      }else{
                        alert("添加失败");
                      }
                    },  
                 error : function(result) {  
                     alert("网络出问题了!");
                  }  
               });  
          }