$(document).ready(function() {
	//使用summernote
	$("#content").summernote({
		height: 200,
		lang: 'zh-CN',
		placeholder: '请详细描述问题',
		toolbar: [
			['style', ['bold', 'italic', 'underline', 'clear', 'strikethrough']],
			['para', ['ul', 'ol']]
		]
	});
	
	$(document).click(function() {
		$("#tags").hide();
	});	               

	$("#tagsInputDiv").click(function(event){
		event.stopPropagation();
		$("#tags").show();
	});
	
	$("#tags").click(function() {
		event.stopPropagation();
	});
	
	$("#tagsField a").click(function(){
		event.stopPropagation();
		var tagContentId = $(this).attr("href");
		$(tagContentId).siblings().hide();
		$(tagContentId).show();
	});
	
	
	$(".tagPanel a").click(function(){
		var tag = $(this).text();
		var tagInput = $("#tagStr");
		
		//如果已经存在这个tag 不给添加
		if (tagInput.tagExist(tag)) {
			return;
		}
		
		//限制最多5个标签
		var input = tagInput.siblings('.tagsinput');
		var maxLen = 5;
	    if(input.children('span.tag').length >= maxLen){
	        return;
	    }
	    
		//添加
		tagInput.addTag(tag);
	});
	
	$('#tagStr').tagsInput({
		'height':'55px',
		'width':'auto',
		'defaultText':'标签',
		'onChange': function() {
					    var input = $(this).siblings('.tagsinput');
					    var maxLen = 5;
					    if(input.children('span.tag').length >= maxLen){
					        input.children('div').hide();
					    }
					    else{
					        input.children('div').show();
					    }
					},
		'placeholderColor' : '#999'
	});
	
});