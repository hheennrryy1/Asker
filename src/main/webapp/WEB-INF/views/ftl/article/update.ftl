<#import "*/layout/layout.ftl" as l>

<@l.htmlHead "更新文章 - Asker">
		<link rel="stylesheet" href="${path}/css/public/summernote.css" />
		<script src="${path}/js/public/summernote.min.js"></script>
		<script src="${path}/js/public/summernote-zh-CN.min.js"></script>
		<script>
			$(document).ready(function() {
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
		</script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal" action="${path}/article/update" role="form" method="POST"> 
					<input type="hidden" name="id" value="${article.id}"/>
					<div class="form-group">
						<label for="title" class="col-md-2 control-label"><b>标题</b></label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="title" name="title" placeholder="标题" maxlength="50" required="required" value="${article.title}"/>
						</div>
					</div>
					<div class="form-group">
						<textarea name="content" id="content">${article.content}</textarea>
					</div>					
										
					<div class="col-md-offset-8">
						<button type="submit" class="btn btn-primary">更新</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</@l.htmlBody>