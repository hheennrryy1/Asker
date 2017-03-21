$(document).ready(function() {
	$(".dropdown-toggle").dropdown();
	
	$(".addComment").on("click", function() {
		$('#myModal').modal();
		var answerId = $(this).next().val();
		var questionId = $(this).next().next().val();
		$("#modalAnswerId").val(answerId);
		$("#modalQuestionId").val(questionId);
		
		$.getJSON("/Asker/comment/select/" + answerId, function(json){
			$.each(json, function(index) {
				$("#comments").append("<div>" + json[index].content
						+ "<a href='/Asker/user/" + json[index].user.id + "'" +  ">" + "<br />"
						+ json[index].user.username + "</a>"
						+ "</div>"
				);
			});
		});
	});
	
	$("#answerContent").summernote({
		height: 100,
		lang: 'zh-CN',
		placeholder: '写回答',
		toolbar: [
			['style', ['bold', 'italic', 'underline', 'clear', 'strikethrough']],
			['para', ['ul', 'ol']]
		]
	});
	
	$("#answerForm").submit(function() {
		if($("#answerContent").summernote('isEmpty')) {
			return false;
		}
		return true;
	});
	
	$(".edit").click(function() {
		$(this).hide();
		var edit = $(this);
		var content = $(this).parent().prev("div");
		$(content).summernote({
			height: 100,
			lang: 'zh-CN',
			toolbar: [
				['style', ['bold', 'italic', 'underline', 'clear', 'strikethrough']],
				['para', ['ul', 'ol']]
			]
		});
		//获取修改前的内容，以便恢复。
		var markupStr = $(content).summernote('code');
		
		$(this).parent().append("<div class='col-md-offset-9 col-md-3' id='btnDiv'>"+
								"<button class='btn btn-danger' id='cancelEditAnswer'>取消 </button>" + "&nbsp;" +
								"<button class='btn btn-primary' id='updateAnswer'>修改</button>" +
								"</div>"
								);
		
		$("#cancelEditAnswer").click(function() {
			$(content).summernote('code', markupStr);
			$(content).summernote('destroy');
			$('#btnDiv').remove();
			edit.show();
		}); 
		
 		$("#updateAnswer").click(function() {
			var contentText = $(content).summernote('code');
			var answerId = edit.next("input[name='answerId']").val();
			var questionId = edit.nextAll("input[name='questionId']").val();
			
			var args = {
					id : answerId,
					content : contentText
			};
			
			$.post(path + "/answer/update", args, function(json) {
				if(json.flag > 0) {
					$(content).summernote('destroy');
					$('#btnDiv').remove();
					edit.show();
				}
				if(json.flag <= 0) {
					alert("修改失败");
				}
			});
		});
		 
	}); 
});