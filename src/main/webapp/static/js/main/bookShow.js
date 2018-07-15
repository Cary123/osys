$(document).ready(function(){
	$("#showSendArea").click(function(){
		$("#showSend").toggle();
	});
	
	$("#btnPostMsg").click(function(){
		if (!UE.getEditor('editor').hasContents()){
			alert('请先填写内容!');
			}else{
				var content = UE.getEditor('editor').getContent();
				var bookId = $("#bookNote").attr("data-bookid");
				$.ajax({
					type : "post",
					url : "main/publishBookNote",
					data : {
						editorValue : content,
						bookId  : bookId
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
										+"       <label style='color: red; font-size: 12px'>&nbsp&nbsp&nbsp刚刚发表</label>"
										+"    </div>"
										+"    <div class='question-content rich-text aimgPreview'>"+content
										+"    </div>"
										+"</div>";
								
										$("#bookNoteList").prepend(html);
										var answerCount = $("#answerCount").attr("data-content");
										var nowCount = parseInt(answerCount)+1;
										$("#answerCount").attr("data-content", nowCount);
										$("#answerCount").html(nowCount+"次回答");
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
})