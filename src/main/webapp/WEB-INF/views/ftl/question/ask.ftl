<#import "*/layout/layout.ftl" as l>

<@l.htmlHead "提问 - Asker">
		<link rel="stylesheet" href="${path}/css/public/summernote.css" />
		<link rel="stylesheet" href="${path}/css/public/jquery.tagsinput.min.css" />
		<link rel="stylesheet" href="${path}/css/my/question/ask.css" />
		<script src="${path}/js/public/summernote.min.js"></script>
		<script src="${path}/js/public/summernote-zh-CN.min.js"></script>
		<script src="${path}/js/public/jquery.tagsinput.min.js"></script>
		<script src="${path}/js/my/question/ask.js"></script>
</@l.htmlHead>

<@l.htmlBody>
	<div class="container">
		<form action="${path}/question/ask" method="POST">
		
			<div class="form-group">
				<input type="text" class="form-control" id="title" name="title" 
					required="required" placeholder="标题：简洁明了，用问号结尾" maxlength="80"/>
			</div>
			
			<div id="tagsInputDiv">
				<input type="text" id="tagStr" name="tagStr" required="required"/>
			</div>
			
			<br />
			
			<div id="tags" class="tags">
				<div id="tagsField">
					<ul class="breadcrumb">
						<li><a href="#language">开发语言</a></li>
						<li><a href="#framework">开发平台</a></li>
						<li><a href="#server">服务器</a></li>
						<li><a href="#database">数据库和缓存</a></li>
						<li><a href="#tool">工具</a></li>
						<li><a href="#device">设备</a></li>
						<li><a href="#other">其它</a></li>
					</ul>
				</div>
								
				<div class="tagContent" id="tagContent">
					<div class="tagPanel" id="language">
						<ul class="breadcrumb">
							<li><a href="javascript:void(0)">java</a></li>
							<li><a href="javascript:void(0)">javascript</a></li>
							<li><a href="javascript:void(0)">php</a></li>
							<li><a href="javascript:void(0)">c++</a></li>
							<li><a href="javascript:void(0)">css</a></li>
							<li><a href="javascript:void(0)">html</a></li>
							<li><a href="javascript:void(0)">python</a></li>
							<li><a href="javascript:void(0)">html5</a></li>
							<li><a href="javascript:void(0)">node.js</a></li>
							<li><a href="javascript:void(0)">c</a></li>
							<li><a href="javascript:void(0)">objective-c</a></li>
							<li><a href="javascript:void(0)">shell</a></li>
							<li><a href="javascript:void(0)">swift</a></li>
							<li><a href="javascript:void(0)">golang</a></li>
							<li><a href="javascript:void(0)">ruby</a></li>
							<li><a href="javascript:void(0)">c#</a></li>
							<li><a href="javascript:void(0)">bash</a></li>
							<li><a href="javascript:void(0)">.net</a></li>
							<li><a href="javascript:void(0)">sass</a></li>
							<li><a href="javascript:void(0)">scala</a></li>
							<li><a href="javascript:void(0)">lua</a></li>
							<li><a href="javascript:void(0)">less</a></li>
							<li><a href="javascript:void(0)">perl</a></li>
							<li><a href="javascript:void(0)">erlang</a></li>
							<li><a href="javascript:void(0)">rust</a></li>
							<li><a href="javascript:void(0)">typescript</a></li>
						</ul>
					</div>
					<div class="tagPanel" id="framework">
						<ul class="breadcrumb">
							<li><a href="javascript:void(0)">laravel</a></li>
							<li><a href="javascript:void(0)">flask</a></li>
							<li><a href="javascript:void(0)">django</a></li>
							<li><a href="javascript:void(0)">spring</a></li>
							<li><a href="javascript:void(0)">express</a></li>
							<li><a href="javascript:void(0)">ruby-on-rails</a></li>
							<li><a href="javascript:void(0)">tomado</a></li>
							<li><a href="javascript:void(0)">yii</a></li>
							<li><a href="javascript:void(0)">koa</a></li>
							<li><a href="javascript:void(0)">struts</a></li>
						</ul>
					</div>
					<div class="tagPanel" id="server">
						<ul class="breadcrumb">
							<li><a href="javascript:void(0)">linux</a></li>
							<li><a href="javascript:void(0)">nginx</a></li>
							<li><a href="javascript:void(0)">apache</a></li>
							<li><a href="javascript:void(0)">ubuntu</a></li>
							<li><a href="javascript:void(0)">docker</a></li>
							<li><a href="javascript:void(0)">centos</a></li>
							<li><a href="javascript:void(0)">缓存</a></li>
							<li><a href="javascript:void(0)">tomcat</a></li>
							<li><a href="javascript:void(0)">负载均衡</a></li>
							<li><a href="javascript:void(0)">unix</a></li>
							<li><a href="javascript:void(0)">hadoop</a></li>
							<li><a href="javascript:void(0)">windows-server</a></li>
						</ul>
					</div>
					<div class="tagPanel" id="database">
						<ul class="breadcrumb">
							<li><a href="javascript:void(0)">mysql</a></li>
							<li><a href="javascript:void(0)">oracle</a></li>
							<li><a href="javascript:void(0)">sqlserver</a></li>
							<li><a href="javascript:void(0)">redis</a></li>
							<li><a href="javascript:void(0)">sql</a></li>
							<li><a href="javascript:void(0)">mongodb</a></li>
							<li><a href="javascript:void(0)">nosql</a></li>
							<li><a href="javascript:void(0)">memcached</a></li>
							<li><a href="javascript:void(0)">sqlite</a></li>
							<li><a href="javascript:void(0)">memcached</a></li>
							<li><a href="javascript:void(0)">postgresql</a></li>
						</ul>
					</div>
					<div class="tagPanel" id="tool">
						<ul class="breadcrumb">
							<li><a href="javascript:void(0)">eclipse</a></li>
							<li><a href="javascript:void(0)">maven</a></li>
							<li><a href="javascript:void(0)">git</a></li>
							<li><a href="javascript:void(0)">github</a></li>
							<li><a href="javascript:void(0)">vim</a></li>
							<li><a href="javascript:void(0)">xcode</a></li>
							<li><a href="javascript:void(0)">sublime-text</a></li>
							<li><a href="javascript:void(0)">svn</a></li>
							<li><a href="javascript:void(0)">intellij-idea</a></li>
							<li><a href="javascript:void(0)">ide</a></li>
							<li><a href="javascript:void(0)">atom</a></li>
							<li><a href="javascript:void(0)">visual-studio</a></li>
							<li><a href="javascript:void(0)">emacs</a></li>
							<li><a href="javascript:void(0)">visual-studio-code</a></li>
							<li><a href="javascript:void(0)">hg</a></li>
						</ul>
					</div>
					<div class="tagPanel" id="device">
						<ul class="breadcrumb">
							<li><a href="javascript:void(0)">iOS</a></li>
							<li><a href="javascript:void(0)">andriod</a></li>
							<li><a href="javascript:void(0)">chrome</a></li>
							<li><a href="javascript:void(0)">windows</a></li>
							<li><a href="javascript:void(0)">iPhone</a></li>
							<li><a href="javascript:void(0)">iPad</a></li>
							<li><a href="javascript:void(0)">Safari</a></li>
							<li><a href="javascript:void(0)">Opera</a></li>
							<li><a href="javascript:void(0)">ie</a></li>
						</ul>
					</div>
					<div class="tagPanel" id="other">
						<ul class="breadcrumb">
							<li><a href="javascript:void(0)">html5</a></li>
							<li><a href="javascript:void(0)">react.js</a></li>
							<li><a href="javascript:void(0)">搜索引擎</a></li>
							<li><a href="javascript:void(0)">virtualenv</a></li>
							<li><a href="javascript:void(0)">lucene</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<textarea name="content" id="content"></textarea>
			</div>
			
			<button type="submit" class="btn btn-primary btn-block">提问</button>
		</form>
	</div>
</@l.htmlBody>