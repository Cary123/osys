$(document).ready(function(){
	
	
	function ListBookShow(pageNum){
		
		 $.ajax({
			type: 'POST',  
	             url :"listBookShow",
	             dataType: 'json',
	             //contentType:'application/json;charset=UTF-8',
	             contentType: "application/x-www-form-urlencoded",
	             data: {  
	                  keywords:keyWords,
	                  currentPage:pageNum
	             },  
	             success: function(data){ 
	           	    if(data.returnCode == 1)
	           	    {
	           	        alert(data);
	           	    	$("#mainBox").html("");
	           	    }
	               },
	           error : function() { 
	           	   alert("error"); 
	               return false;  
	            }   
	           }); 
       }
})