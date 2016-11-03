<#import "layout/personalPageLayout.ftl" as l>

<@l.info>
	<div class="panel panel-default">
		<h5>${personalPageUser.username!''}的回答</h5>
		<div class="panel-body">
			<#list aPage.list as answer>
				<h6><a href="${path}/question/${answer.question.id}/answer/${answer.id}">${answer.question.title}</a></h6>
				
				<div class="row">
					<div class="col-md-1 like text-center">
						${answer.answerCounter.likesCount}
						<br />赞同
					</div>
					<div class="col-md-11">
						<b>${personalPageUser.username!''}</b>
						<div>${answer.content}</div>
					</div>
				</div>
			</#list>
			<#if aPage.list?size == 0 >
				暂时没有回答
			</#if>
		</div>
	</div>
</@l.info>

