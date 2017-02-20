<#import "layout/layout.ftl" as l>

<@l.htmlHead "首页 - Asker">
	<style>
		#question {
			margin-top: 10px;
		}
		#tags {
			background-color: #ECF0F1;
		}
		#tags a {
			color: #3498DB;
		}
	</style>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<div class="panel panel-success">
			<div class="panel-heading">最新提问</div>
			<#list questions as q>
				<div id="question">
					<div>
						<a href="${path}/question/1?pageNum=1">${q.title}</a>
						<span id="tags">
							<#list q.tags as tag>
								<a href="">${tag.name}</a>
							</#list>
						</span>
					</div>
				</div>
			</#list>
		</div>
		
		<div class="panel panel-info">
			<div class="panel-heading">最新文章</div>
			<#list questions as q>
				<div id="question">
					<div>
						<a href="${path}/question/1?pageNum=1">${q.title}</a>
						<span id="tags">
							<#list q.tags as tag>
								<a href="">${tag.name}</a>
							</#list>
						</span>
					</div>
				</div>
			</#list>
		</div>
	</div>
</@l.htmlBody>