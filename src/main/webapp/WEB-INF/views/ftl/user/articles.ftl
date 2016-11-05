<#import "layout/personalPageLayout.ftl" as l>

<@l.info>
	<div class="panel panel-default">
		<h5>${personalPageUser.username!''}的专栏</h5>
		<div class="panel-body">
			<#if columns?size == 0>
				<a href="${path}/columns/create">创建专栏</a>
			<#else>
				<div>
					<#list columns as column>
						<a href="${path}/columns/${column.id}">${column.title}</a>
						<#if column.summary?length lt 20>   
							<small>${column.summary}</small>
						<#else> 
						     <small>${column.summary[0..29]}...</small> 
						</#if>
					</#list>
				</div>
			</#if>
		</div>
	</div>
</@l.info>