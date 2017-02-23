<#import "*/layout/layout.ftl" as l>

<@l.htmlHead "写文章 - Asker">
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<div>
			<div class="col-md-6">
				<#list article.tags as t>
					<a href="#">${t.name}</a>
				</#list>
			</div>
			<div class="col-md-6 text-right">
				<a href="${path}/columns/${article.columns.id}">${article.columns.title}</a>
			</div>			
		</div>
		<div class="text-center">
			<h2>${article.title}</h2>
			<a href="${path}/user/${article.user.id}">${article.user.username}</a>
			<img src="${article.user.picture!'/picture/default.png'}" alt="avatar" class="img-thumbnail" height="36" width="36" >
			${article.createdTime?date} 
		</div>
		
		<br />
		
		<div class="text-center">
			${article.content}
		</div>
	</div>
</@l.htmlBody>