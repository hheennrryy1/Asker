<#import "layout/layout.ftl" as l>

<@l.htmlHead "修改密码 - Asker">
		<script src="${path}/js/public/hashes.min.js"></script>
		<script src="${path}/js/my/user/password.js"></script>
		<style>
			.help-block {
				color: red;
			}
		</style>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container panel panel-default">
	
		<ol class="breadcrumb">
			<li><a href="${path}/user/settings">基本资料</a></li>
			<li class="active">修改密码</li>
		</ol>
		
		<form action="${path}/user/editUsername" class="form-horizontal" method="POST" role="form">
			<div class="form-group">
				<label for="username" class="col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 control-label">旧密码</label>
				<div class="col-md-5 col-sm-5">
					<input class="form-control" type="password" name="oldPassword" id="oldPassword" 
						required="required" maxlength="18"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="username" class="col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 control-label">新密码</label>
				<div class="col-md-5 col-sm-5">
					<input class="form-control" type="password" name="password" id="password" 
						required="required" maxlength="18"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="username" class="col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 control-label">确认密码</label>
				<div class="col-md-5 col-sm-5">
					<input class="form-control" type="password" name="confirmPassword" id="confirmPassword" 
						required="required" maxlength="18"/>
				</div>
			</div>
				<div class="help-block text-center"></div>
				<button type="button" class="btn btn-primary btn-block">修改</button>
		</form>
	</div>
</@l.htmlBody>