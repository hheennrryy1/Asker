<#import "layout/layout.ftl" as l>

<@l.htmlHead "编辑个人资料 - Asker">
		<link rel="stylesheet" href="${path}/css/public/fileinput.min.css" />
		<script src="${path}/js/public/fileinput.min.js"></script>
		<script src="${path}/js/public/validator.min.js"></script>
		<script src="${path}/js/public/zh.js"></script>
		<style>
			.kv-avatar .file-preview-frame,.kv-avatar .file-preview-frame:hover {
			    margin: 0;
			    padding: 0;
			    border: none;
			    box-shadow: none;
			    text-align: center;
			}
			.kv-avatar .file-input {
			    display: table-cell;
			    max-width: 220px;
			}
		</style>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container panel panel-default">
		<form action="${path}/user/edit" method="POST" data-toggle="validator" role="form"
		 enctype="multipart/form-data" class="form-horizontal">
			<div id="kv-avatar-errors-2" class="center-block" style="width:800px;display:none"></div>
		    <div class="kv-avatar center-block" style="width:200px">
		        <input id="avatar-2" name="file" type="file" class="file-loading">
		    </div>
			
			<div class="form-group">
				<label class="col-md-2 col-sm-2 control-label">性别</label>
				<div class="col-sm-1 col-md-1">
		            <input type="radio" name="sex" value="1" <#if Session.user.sex == true>checked="checked"</#if> /> 男
				</div>
				<div class="col-sm-1 col-md-1">
		            <input type="radio" name="sex" value="0" <#if Session.user.sex == false>checked="checked"</#if> /> 女
				</div>
			</div>
						
			<div class="form-group">
				<label for="city" class="col-md-2 col-sm-2 control-label">居住地</label>
				<div class="col-md-10 col-sm-10">
					<input type="text" class="form-control" maxlength="50" name="city" id="city" value="${Session.user.city}"/>
				</div>			
			</div>
			
			<div class="form-group">
				<label for="company" class="col-md-2 col-sm-2 control-label">公司或组织名称</label>
				<div class="col-md-10 col-sm-10">
					<input type="text" class="form-control" maxlength="50" name="company" id="company" value="${Session.user.company}"/>			
				</div>
			</div>
			
			<div class="form-group">
				<label for="position" class="col-md-2 col-sm-2 control-label">你的职位</label>
				<div class="col-md-10 col-sm-10">
					<input type="text" class="form-control" maxlength="50" name="position" id="position" value="${Session.user.position}"/>
				</div>			
			</div>
			
			<div class="form-group">
				<label for="signature" class="col-md-2 col-sm-2 control-label">个性签名</label>
				<div class="col-md-10 col-sm-10">
					<input type="text" class="form-control" maxlength="140" name="signature" id="signature" value="${Session.user.signature}"/>
				</div>			
			</div>
			
			<button type="submit" class="btn btn-primary btn-block">修改</button>
		</form>
	</div>
	
	<script>
		$("#avatar-2").fileinput({
			language: 'zh',
		    overwriteInitial: true,
		    maxFileSize: 1500,
		    showClose: false,
		    showCaption: false,
		    showBrowse: false,
		    browseOnZoneClick: true,
		    removeLabel: '',
		    removeIcon: '<i class="glyphicon glyphicon-remove"></i>',
		    removeTitle: 'Cancel or reset changes',
		    elErrorContainer: '#kv-avatar-errors-2',
		    msgErrorClass: 'alert alert-block alert-danger',
		    defaultPreviewContent: '<img src="${Session.user.picture!'http://localhost/picture/default.png'}" alt="${Session.user.username}" style="width:160px"><h6 class="text-muted">Click to select</h6>',
		    layoutTemplates: {main2: '{preview}' + ' {remove}'},
		    allowedFileExtensions: ["jpg", "png", "gif"]
		});
	</script>
</@l.htmlBody>