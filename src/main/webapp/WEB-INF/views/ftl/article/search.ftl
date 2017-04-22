<#import "*/layout/layout.ftl" as l>

<@l.htmlHead "文章">
	<style>
		.article {
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
			<div class="panel-heading">全部文章</div>
			<#list page.list as a>
				<div class="article">
					<div>
						<a href="${path}/article/${a.id}">${a.title}</a>
						<span class="tags">
							<#list a.tags as tag>
								<a href="${path}/tag/${tag.id}/articles">${tag.name}</a>
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