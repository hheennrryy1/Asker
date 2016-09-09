<#import "layout/personalPageLayout.ftl" as l>

<@l.info>
	<div class="panel panel-default">
		<h5>${personalPageUser.username!''}的提问</h5>
		<div class="panel-body">
			<#list qPage.list as question>
				<h5><a href="${path}/question/${question.id}">${question.title}</a></h5>
			</#list>
		</div>
	</div>
</@l.info>

