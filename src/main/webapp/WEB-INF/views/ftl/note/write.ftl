<#import "*/layout/layout.ftl" as l>

<@l.htmlHead "记笔记">
		<link rel="stylesheet" href="${path}/css/public/summernote.css" />
		<script src="${path}/js/public/summernote.min.js"></script>
		<script src="${path}/js/public/summernote-zh-CN.min.js"></script>
		<script src="${path}/js/my/note/write.js"></script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<div class="panel panel-default">
			<h5>记笔记</h5>
			<div class="panel-body">
				<form class="form-horizontal" action="${path}/note/write" role="form" method="POST"> 
					<div class="form-group">
						<div class="row">
							<label for="title" class="col-md-2 control-label"><b>标题</b></label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="title" name="title" placeholder="标题" maxlength="50" required="required"/>
							</div>
						</div>						
		 				<div class="row">
							<label class="col-md-2 control-label"><b>是否公开</b></label>
							<div class="col-md-1">
								否<input type="radio" checked="checked" name="authority" value="0"/>
							</div>
							<div class="col-md-1">
								是<input type="radio" name="authority" value="1"/>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<textarea name="content" id="content"></textarea>
					</div>					
					
					<div class="col-md-offset-8">
						<button type="submit" class="btn btn-primary">发布笔记</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</@l.htmlBody>