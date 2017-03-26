<#import "*/layout/layout.ftl" as l>
<#import "*/layout/tagLayout.ftl" as t>

<@l.htmlHead "写文章 - Asker">
		<link rel="stylesheet" href="${path}/css/public/summernote.css" />
		<link rel="stylesheet" href="${path}/css/public/jquery.tagsinput.min.css" />
		<link rel="stylesheet" href="${path}/css/my/article/write.css" />
		<script src="${path}/js/public/jquery.tagsinput.min.js"></script> 
		<script src="${path}/js/public/summernote.min.js"></script>
		<script src="${path}/js/public/summernote-zh-CN.min.js"></script>
		<script src="${path}/js/my/article/write.js"></script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal" action="${path}/article/write" role="form" method="POST"> 
					<div class="form-group">
						<label for="title" class="col-md-2 control-label"><b>标题</b></label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="title" name="title" placeholder="标题" maxlength="50" required="required"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="tagStr" class="col-md-2 control-label"><b>标签</b></label>
						<div class="col-md-8" id="tagsInputDiv">
							<input type="text" id="tagStr" name="tagStr" required="required"/>
						</div>
					</div>
					
					<@t.tag></@t.tag>
					
					<div class="form-group">
						<textarea name="content" id="content"></textarea>
					</div>					
										
					<div class="col-md-offset-8">
						<button type="submit" class="btn btn-primary">创建</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</@l.htmlBody>