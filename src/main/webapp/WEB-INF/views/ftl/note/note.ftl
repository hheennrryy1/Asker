<#import "*/layout/layout.ftl" as l>

<@l.htmlHead "${note.title}">
	<script>
		$(document).ready(function() {
			$("#delete").click(function() {
				var con;
				con = confirm("确定删除吗?"); //在页面上弹出对话框
				if(con == true) {
					$.get("/Asker/note/delete/" + ${note.id},function(data,status){
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
		<div class="text-center">
			<h3>${note.title}</h3>
			<a href="${path}/user/${note.user.id}">${note.user.username}</a>
			<img src="${note.user.picture!'/picture/default.png'}" alt="avatar" class="img-thumbnail" height="36" width="36" >
			${note.createdTime?date} 
			<#if Session.user.id == note.user.id>
				<a href="${path}/note/update/${note.id}"><i class="fa fa-edit"></i>编辑</a>
				<a href="javascript:void(0);" id="delete"><i class="fa fa-trash"></i>删除</a>
			</#if>
		</div>
		
		<br />
		<div class="text-center">
			${note.content}
		</div>
	</div>
</@l.htmlBody>