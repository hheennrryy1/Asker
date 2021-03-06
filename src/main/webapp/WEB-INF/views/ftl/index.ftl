<#import "layout/layout.ftl" as l>

<@l.htmlHead "首页 - Asker">
	<style>
		.question {
			margin-top: 10px;
		}
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
			<div class="panel-heading">最新提问</div>
			<#list qpage.list as q>
				<div class="question">
					<div>
						<a href="${path}/question/${q.id}">${q.title}</a>
						<span class="tags">
							<#list q.tags as tag>
								<a href="${path}/tag/${tag.id}/questions">${tag.name}</a>
							</#list>
						</span>
					</div>
				</div>
			</#list>
		</div>
		
		<div class="panel panel-info">
			<div class="panel-heading">最新文章</div>
			<#list apage.list as a>
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
	</div>
</@l.htmlBody>