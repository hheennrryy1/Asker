<#import "*/layout/layout.ftl" as l>

<@l.htmlHead "创建专栏 - Asker">
		<link rel="stylesheet" href="${path}/css/public/jquery.tagsinput.min.css" />
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<div class="panel panel-default">
			<h5>创建专栏</h5>
			<div class="panel-body">
				<form class="form-horizontal" action="${path}/columns/create" role="form" method="POST"> 
					<div class="form-group">
						<label for="title" class="col-md-2 control-label"><b>专栏名称</b></label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="title" name="title" placeholder="专栏名称" maxlength="50" required="required"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="summary" class="col-md-2 control-label"><b>专栏简介</b></label>
						<div class="col-md-8">
							<textarea class="form-control" name="summary" id="summary" rows="10"></textarea>
						</div>
					</div>
					<div class="col-md-offset-8">
						<button type="submit" class="btn btn-primary">创建</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</@l.htmlBody>