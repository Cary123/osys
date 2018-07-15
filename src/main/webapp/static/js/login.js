$(document).ready(function(){
	$("#username").focus(function(){
		$('#divName').hide();
      });
    
    $("#password").focus(function(){
    	$('#divPassword').hide();
      });
	
	$('form').submit(function() {
	        var userName = $('#username').val();
	        var password = $('#password').val();
	        if(userName == ""){
	        	$('#divName').show();
				$('#lblName').html("<strong style='color:#f00;'>"+用户名未填写+"</strong>");
	        }
	        if(password == ""){
	        	$('#divPassword').show();
				$('#lblPassword').html("<strong style='color:#f00;'>"+密码未填写+"</strong>");
	        }
	        
	        
	        $.ajax({  
	              type: "post",  
	              url :"login",
	              dataType: "json",
	              //contentType:'application/json;charset=UTF-8',
	              contentType: "application/x-www-form-urlencoded",
	              data: {  
	                    username : userName, 
	                    password : password
	              },  
	              success: function(data){ 
	            	  if(data.returnCode == 1)
	            	  {
	            		  window.location.href="index";
	            	  }else{
            	    	if(typeof(data.field.result.fillUserName) != "undefined"){
            	    		$('#divName').show();
            				$('#lblName').html("<strong style='color:#f00;'>"+data.field.result.fillUserName+"</strong>");
            	    	}
            	    	if(typeof(data.field.result.userNameNotExist) != "undefined"){
            	    		$('#divName').show();
            	    		$('#lblName').html("<strong style='color:#f00;'>"+data.field.result.userNameNotExist+"</strong>");
            	    	}
            	    	if(typeof(data.field.result.fillPassword) != "undefined"){
            	    		$('#divPassword').show();
            				$('#lblPassword').html("<strong style='color:#f00;'>"+data.field.result.fillPassword+"</strong>");
            	    	}
            	    	if(typeof(data.field.result.passwordWrong) != "undefined"){
            	    		$('#divPassword').show();
            	    		$('#lblPassword').html("<strong style='color:#f00;'>"+data.field.result.passwordWrong+"</strong>");
            	    	}
	            	    	
				  	    $('#tips').css({"color":"red"});
					    $('#tips').html('登录失败');
	            	  }
	                },
	            error : function() {  
	            	$('#tips').css({"color":"red"});
				    $('#tips').html('服务器异常');
	                return false;  
	             }   
	            });  
	        //end ajax            
	    });//click end  
	
	 
});