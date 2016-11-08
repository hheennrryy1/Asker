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
				<div class="col-md-offset-8 col-md-4">
					<#if isMyself>
						<div><a href="${path}/columns/${columns.id}/update"><i class="fa fa-cog"></i>专栏设置</a></div>
					</#if>
					<div><b>作者</b></div>
					<div>
						<img src="${columns.user.picture!'/picture/default.png'}" alt="${columns.user.username!'avatar'}" width="36" height="36"/>
						<a href="${path}/user/${columns.user.id}">${columns.user.username}</a>
					</div>
				</div>
			</div>
		</div>
		
		<a href="">写文章</a>
	</div>
</@l.htmlBody>