<#import "layout/layout.ftl" as l>

<@l.htmlHead "${columns.title} - Asker">
	<style>
		.article {
			margin-top: 10px;
		}
		.tags {
			background-color: #ECF0F1;
		}
		.tags a {
			color: #1ABC9C;
		}
	</style>
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
					<div class="col-md-12">
						<div><a href="${path}/columns/${columns.id}/update"><i class="fa fa-cog"></i>专栏设置</a></div>
					</div>
				</#if>
				<#if isMyself>
					<div class="col-md-8">
						<a href="${path}/article/write" class="btn btn-primary">写文章</a>		
					</div>
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
				<div class="article">
					<a href="${path}/article/${a.id}">${a.title}</a>
					<span class="tags">
						<#list a.tags as t>
							<a href="">${t.name}</a>
						</#list>
					<span>
				</div>
			</#list>
		</div>
	</div>
</@l.htmlBody>