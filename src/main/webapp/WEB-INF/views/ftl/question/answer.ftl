<#import "*/layout/layout.ftl" as l>

<@l.htmlHead "${question.title} - Asker">
	<link rel="stylesheet" href="${path}/css/my/question/question.css" />
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<div id="question">
			<div id="tag">
				<#list question.tags as tag>
					<a href="">${tag.name}</a>
				</#list>
			</div>
			
			<div>
				<h4>${question.title}</h4>
				
				<div id="content">
					${question.content}
				</div>
				
				<div class="text-right">${count}浏览</div>
				
				<div class="row">
					<div class="col-md-offset-9 col-md-3 userInfo">
						<div>
							提问于 ${question.createdTime?datetime}
						</div>
						<div id="avatar" class="col-md-12">
							<img src="${question.user.picture!'/picture/default.png'}" alt="avatar" class="img-thumbnail" height="36" width="36" >
							<a href="${path}/user/${question.user.id}">${question.user.username}</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</@l.htmlBody>