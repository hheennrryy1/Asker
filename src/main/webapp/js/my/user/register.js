$(document).ready(function() {
	
	var usernameDiv = $("#usernameDiv");
	var passwordDiv = $("#passwordDiv");
	var emailDiv = $("#emailDiv");
	
	//验证失败，显示提示信息
	function pattFail(element, help) {
		element.removeClass("has-success");
		element.addClass("has-error");
		help.show();
	}
	
	//验证成功的效果
	function pattSuccess(element, help) {
		element.removeClass("has-error");
		element.addClass("has-success");
		help.hide();
	}
	
	$("button").click(function() {
		
		var username = $("#username").val();
		var password = $("#password").val();
		var email = $("#email").val();
		
		var usernamePatt = /^[\w\u4e00-\u9fa5]{2,15}$/;
		// \w 匹配任何字类字符，包括下划线。与"[A-Za-z0-9_]"等效。
		var pwdPatt = /^[\w]{6,18}$/; //密码(长度在6~18之间，只能包含字母、数字和下划线)
		var emailPatt = /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?$/;
		
		var helpBlock = $(".help-block"); 
		
		var flag = true;
		
		//验证用户名 
		if(usernamePatt.test(username)) {
			pattSuccess(usernameDiv, helpBlock.eq(0));
		}
		else {
			pattFail(usernameDiv, helpBlock.eq(0));
			flag = false;
		}
		
		//验证邮箱
		if(emailPatt.test(email)) {
			var validateFlag = true;
			//验证邮箱是否已经存在
			$.ajax({
				type: "GET",
				url: "user/emailValidate",
				data: { email : email },
				async: false, //同步的，等待验证结果在往下执行
				success: function(data) {
					if(data==="success") {
						pattSuccess(emailDiv, helpBlock.eq(2));
					}
					else {
						pattSuccess(emailDiv, helpBlock.eq(1));//格式正确
						pattFail(emailDiv, helpBlock.eq(2));//邮箱已经存在
						validateFlag = false;
						flag = false;
					}					   
			   }
			});
			
			if(validateFlag) {
				pattSuccess(emailDiv, helpBlock.eq(1));//格式正确
				pattSuccess(emailDiv, helpBlock.eq(2));//邮箱不存在
			}
		}
		else {
			pattFail(emailDiv, helpBlock.eq(1));
			helpBlock.eq(2).hide();
			flag = false;
		}
		
		//验证密码
		if(pwdPatt.test(password)) {
			pattSuccess(passwordDiv, helpBlock.eq(3));
		}
		else {
			pattFail(passwordDiv, helpBlock.eq(3));
			flag = false;
		}
		
		alert("验证结果为:" + flag);
		
		if(flag) {
			var SHA512 = new Hashes.SHA512();
			$("#password").val(SHA512.hex(password));
			$("form").submit();
		}
		
	});
});