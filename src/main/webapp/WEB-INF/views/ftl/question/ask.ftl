<#import "*/layout/layout.ftl" as l>
<#import "*/layout/tagLayout.ftl" as t>

<@l.htmlHead "提问 - Asker">
		<link rel="stylesheet" href="${path}/css/public/summernote.css" />
		<link rel="stylesheet" href="${path}/css/public/jquery.tagsinput.min.css" />
		<link rel="stylesheet" href="${path}/css/my/question/ask.css" />
		<script src="${path}/js/public/summernote.min.js"></script>
		<script src="${path}/js/public/summernote-zh-CN.min.js"></script>
		<script src="${path}/js/public/jquery.tagsinput.min.js"></script>
		<script src="${path}/js/my/question/ask.js"></script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<form action="${path}/question/ask" method="POST">
		
			<div class="form-group">
				<input type="text" class="form-control" id="title" name="title" 
					required="required" placeholder="标题：简洁明了，用问号结尾" maxlength="80"/>
			</div>
			
			<div id="tagsInputDiv">
				<input type="text" id="tagStr" name="tagStr" required="required"/>
			</div>
			
			<@t.tag></@t.tag>
			
			<br />
			
			<div class="form-group">
				<textarea name="content" id="content"></textarea>
			</div>
			
			<button type="submit" class="btn btn-primary btn-block">提问</button>
		</form>
	</div>
</@l.htmlBody>