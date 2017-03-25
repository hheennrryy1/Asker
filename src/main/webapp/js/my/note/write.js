$(document).ready(function() {
	//使用summernote
	$("#content").summernote({
		height: 200,
		lang: 'zh-CN',
		placeholder: '',
		toolbar: [
			['style', ['bold', 'italic', 'underline', 'clear', 'strikethrough']],
			['para', ['ul', 'ol']]
		]
	});
});