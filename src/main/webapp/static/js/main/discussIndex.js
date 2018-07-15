$(document).ready(function(){
	$("#showSendArea").click(function(){
		$("#showSend").toggle();
	});
	
	$("#btnPostMsg").click(function(){
		if (!UE.getEditor('editor').hasContents()){
			alert('请先填写内容!');
			}else{
				var content = UE.getEditor('editor').getContent();
				$.ajax({
					type : "post",
					url : "main/publishQuestion",
					data : {
						editorValue : content
						},
					dataType : "json",
					success : function(data){
							if(data.returnCode == 1)
							{
			 			
			var html=" <div class='ques-answer'> "
					+"    <div class='tag-img'> "
					+"        <img style='height:40px' src='"+data.field.user.photo +"'></img>"
					+"    </div> "
					+"    <div class='from-tag'>"
					+"    来自<label style='color: green; font-size: 15px'>&nbsp&nbsp&nbsp"+data.field.user.username +"&nbsp&nbsp&nbsp</label>"
					+"       <label style='color: red; font-size: 12px'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp刚刚发表</label>"
					+"    </div>"
					+"    <div class='question-content rich-text aimgPreview'>"+content
					+"    </div>"
					+"</div>";
								$("#main").prepend(html);
							}
							else
							{
								alert("Server is busy");
							}
						},
					error: function(){
						}
				});
			}
	});
		/*
		 * var content = $("#textArea").val(); if(content == "") {
		 * alert("输入问题"); return; } $.ajax({ type: 'POST', url
		 * :"publishQuestion", dataType: 'json',
		 * //contentType:'application/json;charset=UTF-8', contentType:
		 * "application/x-www-form-urlencoded", data: { content:content, },
		 * success: function(data){ if(data.code == 1) { alter("ok"); } }, error :
		 * function() { alert("error"); return false; } }); });
		 */
})