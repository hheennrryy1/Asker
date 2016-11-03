<#import "layout/personalPageLayout.ftl" as l>

<@l.info>
	<div class="panel panel-default">
		<h5>${personalPageUser.username!''}的提问</h5>
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
			<#if qPage.list?size == 0 >
				暂时没有提问
			</#if>
		</div>
	</div>
</@l.info>

