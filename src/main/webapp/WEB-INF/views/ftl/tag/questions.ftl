<#import "*/layout/layout.ftl" as l>

<@l.htmlHead "问题">
	<style>
		.question {
			margin-top: 10px;
		}
		.tags {
			background-color: #ECF0F1;
		}
		.tags a {
			color: #1ABC9C;
		}
	</style>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<div class="panel panel-success">
			<div class="panel-heading">全部问题</div>
			<#list page.list as q>
				<div class="question">
					<div>
						<a href="${path}/question/${q.id}">${q.title}</a>
						<span class="tags">
							<#list q.tags as tag>
								<a href="${path}/tag/${tag.id}">${tag.name}</a>
							</#list>
						</span>
					</div>
				</div>
			</#list>
		</div>
		
		<#if page.size gt 0>
			<div class="text-center">
	            <ul class="pagination">
	            	<#list page.navigatepageNums as i>
	              		<li><a href="${path}/questions/?pageNum=${i}">${i}</a></li>
	            	</#list>
	            </ul>
	            <span>共${page.pages}页</span>
			</div> 
		</#if>
	</div>
	
</@l.htmlBody>