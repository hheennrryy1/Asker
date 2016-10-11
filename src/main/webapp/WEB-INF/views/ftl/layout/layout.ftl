<#global path = request.getContextPath()/>

<#macro htmlHead title charset="utf-8" lang="zh-CN">
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>${title}</title>
		<script src="${path}/js/public/jquery.min.js"></script>
		<script src="${path}/js/public/bootstrap.min.js"></script>
		<script>
			var path = "${path}";
		</script>
		<link rel="stylesheet" href="${path}/css/public/bootstrap.min.css" />
		<link rel="stylesheet" href="${path}/css/public/flat-ui.min.css" />
		<link rel="stylesheet" href="${path}/css/public/font-awesome.min.css" />
		<link rel="shortcut icon" href="${path}/imgs/icon/icon-16px.png" /> 
		<style>
			body {
				<!-- min-height: 1000px; -->
			}
			.navbar-static-top {
				margin-bottom: 19px;
			}
			#footer {
				color: #999;
			}
			.panel {
				padding : 20px 20px;
			}
			p {
				word-wrap:break-word;
			}			
		</style>
		<#nested>
	</head>
</#macro>

<#macro htmlBody>
<body>
	<#if Session.user?? && !Session.user.status>
		<div class="alert alert-warning text-center" role="alert">
			你的邮箱 ${user.email} 尚未验证，部分功能将无法使用 
		</div>
	</#if>
	
	<div class="navbar navbar-default navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
                    	<i class="fa fa-list"></i>
                        <span class="sr-only">Toggle navigation</span>
                    </button>
                    <a class="navbar-brand" href="${path}/index">
                    	Asker
                    </a>
                </div>
                
                <div class="navbar-collapse collapse" id="example-navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="#">问答</a></li>
                        <li><a href="#">文章</a></li>
                        <li><a href="#">笔记</a></li>
                    </ul>
                    
					<div>
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="关键字">
								<button type="submit" class="btn btn-success">搜索</button>
							</div>
						</form>    
					</div>
	           		
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">撰写 <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="${path}/question/ask">提问题</a></li>
                                <li><a href="#">写文章</a></li>
                                <li><a href="#">记笔记</a></li>
                            </ul>
                        </li>
                        
						<li><a href="#">提醒</a></li>
                        
						<#if Session.user??>
	                        <li class="dropdown">
	                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
									${Session.user.username}<b class="caret"></b>
								</a>
	                            <ul class="dropdown-menu">
	                                <li><a href="${path}/user/${Session.user.id}">个人主页</a></li>
	                                <li><a href="${path}/user/settings">设置</a></li>
	                                <li><a href="${path}/user/logout">退出登录</a></li>
	                            </ul>
	                        </li>
	                        <#else>
	                        	<li><a href="${path}/login.html">登录</a></li>
						</#if>           
                    </ul>
                    
                </div>
		</div>
	</div>
	            
	<#nested>
	
	<div id="footer">
		<div class="container">
			<hr style="border-color:#BDC3C7;" />
			<div class="copyright" style="float: left;">&copy; 2016 Asker</div>
			<div class="contact" style="float: right;">
				<i class="fa fa-envelope-o"></i>zenghenghao@foxmail.com
			</div>
		</div>
	</div>
	
</body>
</#macro>