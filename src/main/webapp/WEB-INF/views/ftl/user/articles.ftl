<#import "layout/personalPageLayout.ftl" as l>

<@l.info>
	<div class="panel panel-default">
		<h5>${personalPageUser.username!''}的专栏</h5>
		<div class="panel-body">
			<a href="${path}/columns/create">创建专栏</a>
		</div>
	</div>
</@l.info>

