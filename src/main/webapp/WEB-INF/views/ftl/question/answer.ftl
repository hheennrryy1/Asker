<#import "*/layout/layout.ftl" as l>

<@l.htmlHead "${question.title} - Asker">
		<link rel="stylesheet" href="${path}/css/public/summernote.css" />
		<link rel="stylesheet" href="${path}/css/my/question/question.css" />
		<script src="${path}/js/public/flat-ui.min.js"></script>
		<script src="${path}/js/public/summernote.min.js"></script>
		<script src="${path}/js/public/summernote-zh-CN.min.js"></script>
		<script src="${path}/js/my/question/question.js"></script>
		<script src="${path}/js/my/question/vote.js"></script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<div class="col-md-10">
			<div id="question">
				<div id="tag">
					<#list question.tags as tag>
						<a href="">${tag.name}</a>
					</#list>
				</div>
				
				<div>
					<h4>${question.title}</h4>
					<div id="content">
						${question.content}
					</div>
				</div>
			</div>
			
			<br />
			
			<div class="panel panel-default">
				<div class="row">
					<div class="col-md-1 col-sm-1 text-center">
						<div class="votebar vote-like<#if answer.liked?? && answer.liked> voted</#if>">
						
					 		<a<#if answer.liked?? && !answer.liked> href="#"
									<#elseif !answer.liked??> href="#"</#if> title="这个答案对我有帮助"><i class="fa fa-caret-up fa-2x"></i></a>
						 	<input type="hidden" value="${answer.id}" />
						 	
						 	<div>${answer.answerCounter.likesCount}</div>	
						</div>
						
						<div class="votebar vote-dislike<#if answer.liked?? && !answer.liked> voted</#if>">
						
							<a<#if answer.liked?? && answer.liked> href="#"
									<#elseif !answer.liked??> href="#"</#if> title="这个答案没有任何帮助"><i class="fa fa-caret-down fa-2x"></i></a>
						</div>
					</div>
					<div class="panel-body col-md-11">
						<div class="col-md-12 answerContent">
							${answer.content}
						</div>
						
						<#if Session.user.id == answer.user.id>
							<div class="col-md-12">
								<a href="javascript:void(0);" class="edit"><i class="fa fa-edit"></i>编辑</a>
								<input type="hidden" name="answerId" value="${answer.id}"/>
								<input type="hidden" name="questionId" value="${question.id}"/>
							</div>
						</#if>
						
						<div class="col-md-7">
							<span>编辑于${answer.lastUpdated?datetime}</span>
							&nbsp;
							<a href="">评论</a>
						</div>
						<div class="col-md-5 text-right">
							<img src="${answer.user.picture!'/picture/default.png'}" alt="avatar" class="img-thumbnail" height="36" width="36" />
							<a href="${path}/user/${answer.user.id}">${answer.user.username}</a>
						</div>
					</div>
				</div>
			</div>
		</div>
			
		<div class="col-md-2">
			<div class="row">
				<div class="col-md-12">
					<b>关于作者</b>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<img src="${answer.user.picture!'/picture/default.png'}" alt="avatar" class="img-thumbnail" />
				</div>
				<div class="col-md-6">
					<a href="${path}/user/${answer.user.id}">${answer.user.username}</a>
				</div>
			</div>
			
			<br />
			
			<div class="row">
				<div class="col-md-12">
					<b>回答状态</b>
				</div>
			</div>
			<div class="row">
			<div class="col-md-12">
				<p>编辑于${answer.lastUpdated?date}</p>
				<p>问题被浏览${clickCount}次</p>
			</div>
			</div>
		</div>
	</div>
</@l.htmlBody>