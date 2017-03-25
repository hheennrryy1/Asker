<#import "layout/personalPageLayout.ftl" as l>

<@l.info>
	<div class="panel panel-default">
		<h5>${personalPageUser.username!''}的笔记</h5>
		<div class="panel-body">
			<#list notes as note>
				<h6><a href="${path}/note/${note.id}">${note.title}</a></h6>
			</#list>
			<#if notes?size == 0 >
				暂时没有笔记
			</#if>
		</div> 
	</div>
</@l.info>