<#import "*/layout/layout.ftl" as l>

<@l.htmlHead "${article.title}">
	<script>
		$(document).ready(function() {
			$("#delete").click(function() {
				var con;
				con = confirm("确定删除吗?"); //在页面上弹出对话框
				if(con == true) {
					$.get("/Asker/article/delete/" + ${article.id},function(data,status){
						 if(data > 0) {
							window.location.href = "/Asker/index";
						} else {
							alert("删除失败，请重试");
						}
						
					});
				}
			});
		});
	</script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<div>
			<div class="col-md-6">
				<#list article.tags as t>
					<a href="#">${t.name}</a>
				</#list>
			</div>
			<div class="col-md-6 text-right">
				<a href="${path}/columns/${article.columns.id}">${article.columns.title}</a>
			</div>			
		</div>
		<div class="text-center">
			<h2>${article.title}</h2>
			<a href="${path}/user/${article.user.id}">${article.user.username}</a>
			<img src="${article.user.picture!'/picture/default.png'}" alt="avatar" class="img-thumbnail" height="36" width="36" >
			${article.createdTime?date} 
			<#if Session.user.id == article.user.id>
				<a href="${path}/article/update/${article.id}"><i class="fa fa-edit"></i>编辑</a>
				<a href="javascript:void(0);" id="delete"><i class="fa fa-trash"></i>删除</a>
			</#if>
		</div>
		
		<br />
		
		<div class="text-center">
			${article.content}
		</div>
	</div>
</@l.htmlBody>