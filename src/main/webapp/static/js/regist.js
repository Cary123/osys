var wait = 60;
var enable = true;
var userNameJude = false;
var passwordJude = false;
var rePasswordJude = false;
var userEmailJude = false;

function encryptionPassword(pwd){              
	return $.md5(pwd);      
   }
$(document).ready(function(){
	if(enable){
		$('#regist_button').attr("disabled","disabled");
	}
	
	$('#userName').focus(function(){
		$('#divUserName').hide();
	})
	
	$('#userName').blur(function(){
		if(/^\w+$/.test($('#userName').val()) && $('#userName').val().length > 1 && $('#userName').val().length < 17) {
			$('#divUserName').hide();
			userNameJude = true;
			if(userNameJude && passwordJude && rePassword && userEmailJude){
				$('#regist_button').removeAttr("disabled");
			}
		}else{
			userNameJude = false;
			$('#divUserName').show();
			$('#lblUserName').html("<strong style='color:#f00;'>用户名只能为2-16个英文、数字和下划线！</strong>");
			$('#regist_button').attr("disabled","disabled");
		}
	});
	
	$('#password').focus(function(){
		$('#divPassword').hide();
	})
	$('#password').blur(function(){
		if(/^\w+$/.test($('#password').val()) && $('#password').val().length > 5 && $('#password').val().length < 17) {
			$('#divPassword').hide();
			passwordJude = true;
			if(userNameJude && passwordJude && rePassword && userEmailJude){
				$('#regist_button').removeAttr("disabled");
			}
		}else{
			passwordJude = false;
			$('#divPassword').show();
			$('#lblPassword').html("<strong style='color:#f00;'>密码只能为6-16个英文、数字和下划线！</strong>");
			$('#regist_button').attr("disabled","disabled");
		}
	});
	
	$('#rePassword').focus(function() {
		$('#divRePassword').hide();
	})
	$('#rePassword').blur(function(){
		if($('#password').val() == $('#rePassword').val()) {
			rePasswordJude = true;
			$('#divRePassword').hide();
			if(userNameJude && passwordJude && rePassword && userEmailJude){
				$('#regist_button').removeAttr("disabled");
			}
		}else{
			rePasswordJude = false;
			$('#divRePassword').show();
			$('#lblRePassword').html("<strong style='color:#f00;'>两次密码输入不一致！</strong>");
			$('#regist_button').attr("disabled","disabled");
		}
	});
	
	$('#userEmail').focus(function() {
		$('#divEmail').hide();
	})
	$('#userEmail').blur(function(){
		if(/[^@]+@[^@]+\.[a-zA-Z]{2,6}/.test($('#userEmail').val()))
		{
			$('#divEmail').hide();
			userEmailJude = true;
			if(userNameJude && passwordJude && rePassword && userEmailJude){
				$('#regist_button').removeAttr("disabled");
			}
		}else{
			userEmailJude = false;
			$('#divEmail').show();
			$('#lblEmail').html("<strong style='color:#f00;'>邮箱格式不正确！</strong>");
			$('#regist_button').attr("disabled","disabled");
		}
	});
	
	$('#userCode').focus(function() {
		$('#divCode').hide();
	})
	$('#get_code').click(function(){
		 if(userEmailJude){
			 time(this);
			 var email = $('#userEmail').val();
			 $("#get_code").attr("disabled",false);
			 $.ajax({  
	             type: 'post',  
	             dataType: 'json',
 	              //contentType:'application/json;charset=UTF-8',
 	             contentType: "application/x-www-form-urlencoded",
	             url :"getCode",
            	 data:{
            		 email:email
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
			 $('#regist_button').attr("disabled","disabled");
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
  	   
  	    $('#regist_button').click(function() {
  	    	var userSex;
  	        var userName = $('#userName').val();
  	        var password = encryptionPassword($('#password').val());
  	        var rePassword = encryptionPassword($('#rePassword').val());
  	        var userAge = $('#userAge').val();
  	        var userPhone = $('#userPhone').val();
  	        var userEmail = $('#userEmail').val();
  	        var userCode = $('#userCode').val();
  	        var userName = $('#userName').val();
  	        var radios=document.getElementsByName("userSex");
  			for(var i = 0; i < radios.length; i++){
  				if(radios[i].checked){
  					userSex = radios[i].value;
  				}
  			}
  	     // ajax start  
  	          
  	        $.ajax({  
  	              type: 'POST',  
  	              url :"registSubmit",
  	              dataType: 'json',
  	              //contentType:'application/json;charset=UTF-8',
  	              contentType: "application/x-www-form-urlencoded",
  	              data: {  
  	                    userName : userName, 
  	                    password : password,
  	                    rePassword : rePassword,
  	                    userSex : userSex,
  	                    userEmail : userEmail,
  	                    userAge : userAge,
  	                    userPhone : userPhone,
  	                    userCode : userCode
  	              },  
  	              success: function(data){ 
  	            	    if(data.returnCode == 1)
  	            	    {
  	            	    	$('#tips').css({"color":"green"});
  	            	    	$('#tips').html("恭喜   ‘"+userName+'’  注册成功！')
  	            	    }else{
  	            	    	if(typeof(data.field.codeError) != "undefined"){
  	            	    		$('#divCode').show();
  	            				$('#lblCode').html("<strong style='color:#f00;'>验证码错误</strong>");
  	            	    	}
  	            	    	if(typeof(data.field.nameRegisted) != "undefined"){
  	            	    		$('#divUserName').show();
  	            				$('#lblUserName').html("<strong style='color:#f00;'>用户名已经被注册过</strong>");
  	            	    	}
							if(typeof(data.field.userNameError) != "undefined"){
								$('#divUserName').show();
  	            				$('#lblUserName').html("<strong style='color:#f00;'>用户名只能为2-16个英文、数字和下划线！</strong>");
  	            	    	}
							if(typeof(data.field.passwordError) != "undefined"){
  	        					$('#divPassword').show();
  	        					$('#lblPassword').html("<strong style='color:#f00;'>密码只能为6-16个英文、数字和下划线！</strong>");
  	            	    	}
					  	    $('#tips').css({"color":"red"});
						    $('#tips').html('注册失败');
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