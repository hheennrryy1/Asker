<#import "layout/personalPageLayout.ftl" as l>

<@l.info>
	<div class="panel panel-default">
		<h5>${personalPageUser.username!''}的回答</h5>
		<div class="panel-body">
			<#list aPage.list as answer>
				<h6><a href="${path}/question/${answer.question.id}">${answer.question.title}</a></h6>
				<div class="row">
					<div class="col-md-1 like text-center">
						11
					</div>
					<div class="col-md-11">
						<b>${personalPageUser.username!''}</b>
					</div>
				</div>
				<div class="col-md-offset-1 col-md-11">${answer.content}</div>
			</#list>
		</div>
	</div>
</@l.info>

