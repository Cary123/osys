var wait = 60;
$(document).ready(function(){
	$('#get_code').click(function(){
		 if($("#username").val() != ""){
			 time(this);
			 var username = $('#username').val();
			 $("#get_code").attr("disabled",false);
			 $.ajax({  
	             type: 'post',  
	             dataType: 'json',
	              //contentType:'application/json;charset=UTF-8',
	             contentType: "application/x-www-form-urlencoded",
	             url :"getCode",
           	 data:{
           		 userName:username
           	 },
	             success: function(data){  
	                   if(data.returnCode == 1){
	                	   
	                   }else{
	                	   $('#divEmail').show();
	           			   $('#lblEmail').html("<strong style='color:#f00;'>"+data.field.result+"</strong>");
	                   }
	               },
	           error : function() {
	               return false;  
	            }   
	           }); 
		 }else
		 {
			 $('#divEmail').show();
			 $('#lblEmail').html("<strong style='color:#f00;'>邮箱格式不正确！</strong>");
		 }
		 
	});
	   
 	   
 	   function time(o) {
 	       if (wait < 1) {
 	           o.removeAttribute("disabled");           
 	           $('#get_code').html("获取验证码");
 	           wait = 60;
 	       } else {
 	           o.setAttribute("disabled", true);
 	           $('#get_code').html(wait + "秒后可重发");
 	           wait--;
 	           setTimeout(function() {
 	               time(o)
 	           },
 	           1000)
 	       }
 	   }
 	   
 	  $('#username').blur(function(){
 			if(/^\w+$/.test($('#username').val()) && $('#username').val().length > 1 && $('#username').val().length < 17) {
 				$('#divUserName').hide();
 			}else{
 				userNameJude = false;
 				$('#divUserName').show();
 				$('#lblUserName').html("<strong style='color:#f00;'>用户名只能为2-16个英文、数字和下划线！</strong>");
 			}
 		});
 	   
 	  $("#username").focus(function(){
 		  $("#divUserName").hide();
 	  });
 	  
 	 $("#password").focus(function(){
		  $("#divPassword").hide();
	  });
 	 
 	$('#password').blur(function(){
		if(/^\w+$/.test($('#password').val()) && $('#password').val().length > 5 && $('#password').val().length < 17) {
			$('#divPassword').hide();
		}else{
			$('#divPassword').show();
			$('#lblPassword').html("<strong style='color:#f00;'>密码只能为6-16个英文、数字和下划线！</strong>");
		}
	});
 	   
 	$('#rePassword').blur(function(){
		if($('#password').val() == $('#rePassword').val()) {
			$('#divRePassword').hide();
		}else{
			$('#divRePassword').show();
			$('#lblRePassword').html("<strong style='color:#f00;'>两次密码输入不一致！</strong>");
		}
	});
 	
 	$('#userCode').focus(function(){
 		$('#divEmail').hide();
	});
 	
 	
   $("#btnSubmit").click(function(){
	   var username = $("#username").val();
	   var password = $.md5($("#password").val());
	   var rePassword = $.md5($("#rePassword").val());
	   var code = $("#userCode").val();
	   if(code == ""){
		    $('#divEmail').show();
			$('#lblEmail').html("<strong style='color:#f00;'>输入验证码</strong>");
			return;
	   }
	  $.ajax({  
             type: 'post',  
             dataType: 'json',
              //contentType:'application/json;charset=UTF-8',
             contentType: "application/x-www-form-urlencoded",
             url :"findPwd",
     	 data:{
     		 userName : username,
     		 password : password,
     		 rePassword : rePassword,
     		 code : code
     	 },
         success: function(data){  
               if(data.returnCode == 1){
            	   $('#tips').css({"color":"green"});
            	   $('#tips').html("恭喜  ‘"+username+'’ 修改密码成功！')
            	   $('#loginHref').show();
               }else{
            	   if(typeof(data.field.userNameNotExist) != "undefined"){
            		   $('#divUserName').show();
           			   $('#lblUserName').html("<strong style='color:#f00;'>"+data.field.userNameNotExist+"</strong>");
            	   }
            	   if(typeof(data.field.result) != "undefined"){
            		   $('#divEmail').show();
           			   $('#lblEmail').html("<strong style='color:#f00;'>"+data.field.result+"</strong>");
            	   }
            	   $('#tips').css({"color":"red"});
            	   $('#tips').html("修改密码失败");
               }
           },
	       error : function() {
	           return false;  
	        }   
         }); 
	   
   });
});