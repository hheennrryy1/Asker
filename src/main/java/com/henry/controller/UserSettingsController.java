package com.henry.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henry.entity.User;
import com.henry.service.UserService;

@Controller
@RequestMapping("/user")
public class UserSettingsController {
	
	Logger logger = Logger.getLogger(UserSettingsController.class);
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute
	public User getSessionUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}
	
	//跳转到个人设置的页面
	@RequestMapping("/settings")
	public String toSettings() {
		return "user/settings";
	}
	
	//更改用户名
	@RequestMapping(value = "/editUsername", method = RequestMethod.POST)
	public String editUsername(@ModelAttribute User user, HttpSession session) {
		userService.updateByIdSelective(user);
		session.setAttribute("user", user);
		return "redirect:/user/settings";
	}
	
	//跳转到修改密码的页面
	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String toEditPassword() {
		return "user/password";
	}
	
	//验证旧密码是否正确,正确就更新
	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public @ResponseBody String editPassword(@ModelAttribute User user, @RequestParam("oldPassword") String oldPassword,
									@RequestParam("newPassword") String newPassword, HttpSession session) {
		oldPassword = userService.encode(oldPassword, user.getSalt());
		
		if(user.getPassword().equals(oldPassword)) {
			newPassword = userService.encode(newPassword, user.getSalt());
			user.setPassword(newPassword);
			userService.updateByIdSelective(user);
			session.setAttribute("user", user);
			return "success";
		}
		return "fail";
	}
}