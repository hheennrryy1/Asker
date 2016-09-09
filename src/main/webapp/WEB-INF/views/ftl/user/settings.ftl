<#import "layout/layout.ftl" as l>

<@l.htmlHead "帐号设置 - Asker">
		<script src="${path}/js/public/validator.min.js"></script>
</@l.htmlHead>

<@l.htmlBody>

	
	<div class="container panel panel-default">
	
		<ol class="breadcrumb">
			<li class="active">基本资料</li>
			<li class="active"><a href="${path}/user/password">修改密码</a></li>
		</ol>
		
		<form action="${path}/user/editUsername" class="form-horizontal" method="POST" data-toggle="validator" role="form">
			<div class="form-group">
				<label for="username" class="col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 control-label">用户名</label>
				<div class="col-sm-4 col-md-4">
					<input class="form-control" type="text" name="username" id="username" value="${Session.user.username}" 
															required="required" maxlength="15"/>
				</div>
				<div class="col-sm-2 col-md-2">
					<button type="submit" class="btn btn-primary">修改</button>
				</div>
			</div>
		</form>
	</div>
</@l.htmlBody>