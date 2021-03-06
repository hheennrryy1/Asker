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
	<div class="container" id="main">
		
		<div id="question">
			<div id="tag">
				<#list question.tags as tag>
					<a href="${path}/tag/${tag.id}/questions">${tag.name}</a>
				</#list>
			</div>
			
			<div>
				<h4>${question.title}</h4>
				
				<div id="content">
					${question.content}
				</div>
				
				<div class="text-right">问题被浏览${count}次</div>
				
				<div class="row">
					<div class="col-md-offset-9 col-md-3 userInfo">
						<div>
							提问于 ${question.createdTime?datetime}
						</div>
						<div id="avatar" class="col-md-12">
							<img src="${question.user.picture!'/picture/default.png'}" alt="avatar" class="img-thumbnail" height="36" width="36" >
							<a href="${path}/user/${question.user.id}">${question.user.username}</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<br />
		
		<#list page.list as answer>
			<div class="panel panel-default">
				<div class="row">
					<#if Session.user.id != answer.user.id>
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
					<#elseif Session.user.id == answer.user.id>
						<div class="col-md-1 col-sm-1 text-center">
							<div class="votebar">
								${answer.answerCounter.likesCount}								
							</div>
						</div>
					</#if>
					<div class="panel-body col-md-11 col-sm-11">
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
							<a href="javascript:void(0);" class="addComment">评论</a>
							<input type="hidden" value="${answer.id}"/>
							<input type="hidden" value="${question.id}"/>
						</div>
						<div class="col-md-5 text-right">
							<img src="${answer.user.picture!'/picture/default.png'}" alt="avatar" class="img-thumbnail" height="36" width="36" >
							<a href="${path}/user/${answer.user.id}">${answer.user.username}</a>
						</div>
					</div>
				</div>
			</div>
		</#list>

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
			        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        	<h4 class="modal-title" id="myModalLabel">评论</h4>
					</div>
					<div class="modal-body" id="comments">
			       
					</div>
			    	<div class="modal-footer">
						<form action="${path}/comment/add" method="POST">
							<textarea name="content" id="content" cols="50" rows="5"></textarea>
							<input type="hidden" id="modalAnswerId" name="modalAnswerId"/>
							<input type="hidden" id="modalQuestionId" name="modalQuestionId"/>
							<button type="submit" class="btn btn-success" id="commentButton">提交</button>
						</form>
			    	</div>
		    	</div>
			</div>
		</div>
		
		<#if Session.user?? && Session.user.status && !answered>
			<form id="answerForm" action="${path}/answer/add" method="POST">
				<input type="hidden" value="${question.id}" name="questionId"/>
				<div class="col-md-11 col-md-offset-1">
					<h4>撰写答案</h4>
					<textarea name="content" id="answerContent"></textarea>
				</div>
				<div class="col-md-offset-11 col-md-1">
					<button type="submit" class="btn btn-success">发布回答</button>
				</div>
			</form>
		</#if>

		<#if page.size gt 0>
			<div class="text-center">
	            <ul class="pagination">
	            	<#list page.navigatepageNums as i>
	              		<li <#if page.pageNum == i>class="active"</#if>><a href="${path}/question/${question.id}?pageNum=${i}">${i}</a></li>
	            	</#list>
	            </ul>
	            <span>共${page.pages}页</span>
			</div> 
		</#if>
				
		<#if answered>
			<div class="col-md-offset-3 col-md-8">
				<span>一个问题你只能回答一次，但你可以对现有的回答进行修改</span>
			</div>
		</#if>
          
	</div>
</@l.htmlBody>