<#import "layout/layout.ftl" as l>

<@l.htmlHead "${columns.title} - Asker">
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<div class="panel panel-default">
			<h4 class="panel-heading">${columns.title}</h4>
			
			<div>
				<p>${columns.summary}</p>
			</div>
			
			<div class="row">
				<#if isMyself>
					<div class="col-md-8">
						<div><a href="${path}/columns/${columns.id}/update"><i class="fa fa-cog"></i>专栏设置</a></div>
					</div>
				</#if>
				<#if isMyself>
					<a href="${path}/article/write" class="btn btn-primary">写文章</a>		
				</#if>
				<div class="col-md-offset-8 col-md-4">
					<div><b>作者</b></div>
					<div>
						<img src="${columns.user.picture!'/picture/default.png'}" alt="${columns.user.username!'avatar'}" width="36" height="36"/>
						<a href="${path}/user/${columns.user.id}">${columns.user.username}</a>
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="panel panel-info">
			<#list articles as a>
				<div>
						<a href="${path}/article/${a.id}">${a.title}</a>
				</div>
			</#list>
		</div>
	</div>
</@l.htmlBody>