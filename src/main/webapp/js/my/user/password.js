$(document).ready(function() {
	
	$("button").click(function() {
		var oldPassword = $("#oldPassword").val();
		var password = $("#password").val();
		var confirmPassword = $("#confirmPassword").val();
		
		var flag = true;
		
		var pwdPatt = /^[\w]{6,18}$/; //密码(长度在6~18之间，只能包含字母、数字和下划线)
		
		if(!pwdPatt.test(oldPassword) || !pwdPatt.test(password) || !pwdPatt.test(confirmPassword)) {
			$(".help-block").text("长度在6~18之间，只能包含字母、数字和下划线");
			return;
		}
		
		if(password != confirmPassword) {
			$(".help-block").text("两次输入不一致");
			return;
		}
		
		var SHA512 = new Hashes.SHA512();
		oldPassword = SHA512.hex(oldPassword);
		password = SHA512.hex(password);
		
		var args = {
			oldPassword : oldPassword,
			newPassword : password
		};
		
		$.post(path + "/user/password", args, function(data) {
			if(data==="fail") {
				$(".help-block").text("旧密码错误");
				return;
			}
			if(data==="success") {
				$(".help-block").text("修改成功");
			}
		});
		
	});
});