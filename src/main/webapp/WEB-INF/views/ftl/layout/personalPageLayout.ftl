<#import "layout/layout.ftl" as l>

<#macro info>
<@l.htmlHead personalPageUser.username + " - Asker">
		<style>
			.info {
				margin-bottom: 0px;
			}
			.profile-nav a{
				font-size: 30px;
			}
			.like {
				background-color: #2ECC71;
			}
		</style>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
	
		<div class="panel panel-default info">
			
			<div class="row">
				<div class="col-xs-5 col-md-2">
					<img src="${personalPageUser.picture!'/picture/default.png'}" height="140" width="140" alt="${personalPageUser.username!'avatar'}" >
				</div>
				
				<#escape x as x?html>
				<div class="col-xs-7 col-md-10">
					<div class="col-md-12">
						<h5>${personalPageUser.username!""}</h5>
					</div>
						
					<div class="col-md-12">
						<i class="fa fa-map-marker"></i>
						<span>${personalPageUser.city!"未填写"}</span> &nbsp;&nbsp;&nbsp;
						
						<#if personalPageUser.sex??>
							<#if personalPageUser.sex>
									<i class="fa fa-mars"></i>
								<#elseif !personalPageUser.sex>
									<i class="fa fa-venus"></i>		
							</#if>
						</#if>
					</div>	
					
					<div class="col-md-12">
						<i class="fa fa-user"></i>
						<span>${personalPageUser.company!"未填写"}</span>		
						<span>${personalPageUser.position!"未填写"}</span>		
					</div>
					
					<div class="col-md-12">
						<p>${personalPageUser.signature!""}</p>	
					</div>
				</div>
			</div>
			
			<div>
				<span>获得<i class="fa fa-thumbs-up"></i>赞同</span>
				<#if isMyself>
					<span style="float:right;">
						<a href="${path}/user/edit" class="btn btn-primary">完善我的资料</a>
					</span>
				</#if>
			</div>
			</#escape>
		</div>
		
		<div class="profile-nav text-center">
			<a href="${path}/user/${personalPageUser.id}"><i class="fa fa-home fa-lg"></i></a>
			<a href="${path}/user/${personalPageUser.id}/asks">提问</a>
			<a href="${path}/user/${personalPageUser.id}/answers">回答</a>
			<a href="">文章</a>
			<a href="">笔记</a>
		</div>
		<#nested>
	</div>	
		
</@l.htmlBody>

</#macro>