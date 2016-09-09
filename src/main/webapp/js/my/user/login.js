$(document).ready(function() {
	
	$("button").click(function() {
		var emailPatt = /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?$/;
		var email = $("#email").val();
		
		var SHA512 = new Hashes.SHA512();
		var password = $("#password").val();
		password = SHA512.hex(password);	
		
		var url = "user/login";
		
		var args = {
			email : email,
			password : password
		};
		
		
		if(emailPatt.test(email)) {
			$.post(url, args, function(data) {
				if(data === true) {
					window.location.href = "index";
				}
				if(data === false) {
					$(".help-block").text("用户名或密码错误");
				}
			});
		}
		else {
			$(".help-block").text("邮箱格式错误");
		}
	});
});