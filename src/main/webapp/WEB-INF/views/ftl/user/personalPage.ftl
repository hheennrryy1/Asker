<#import "layout/personalPageLayout.ftl" as l>

<@l.info>
	<div class="panel panel-default">
		<div>
			<h6>提问</h6>
		</div>
		
		<div class="panel-body">
			<#list qPage.list as question>
				<div class="row click">
					<div class="col-md-1 clickCount text-center">
						${question.questionCounter.clickCount}
						<br />浏览
					</div>
					<div class="col-md-11">
						<h6><a href="${path}/question/${question.id}">${question.title}</a></h6>
					</div>
				</div>
			</#list>
		</div>
	</div>
		
	<div class="panel panel-default">
		<div>
			<h6>回答</h6>
		</div>
		
		<div class="panel-body">
			<#list aPage.list as answer>
				<h6><a href="${path}/question/${answer.question.id}">${answer.question.title}</a></h6>
				
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
		</div>						
	</div>
</@l.info>