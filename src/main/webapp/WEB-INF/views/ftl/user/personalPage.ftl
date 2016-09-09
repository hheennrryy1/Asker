<#import "layout/personalPageLayout.ftl" as l>

<@l.info>
	<div class="panel panel-default">
		<div>
			<h6>提问</h6>
		</div>
		
		<div class="panel-body">
			<#list qPage.list as question>
				<h5><a href="${path}/question/${question.id}">${question.title}</a></h5>
			</#list>
		</div>
	</div>
		
	<div class="panel panel-default">
		<div>
			<h6>回答</h6>
		</div>
		
		<div class="panel-body">
			<#list aPage.list as answer>
				<h5><a href="${path}/question/${answer.question.id}">${answer.question.title}</a></h5>
				${answer.content}
			</#list>
		</div>						
	</div>
</@l.info>