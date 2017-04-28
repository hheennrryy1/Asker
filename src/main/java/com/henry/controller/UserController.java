package com.henry.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henry.entity.User;
import com.henry.service.MailService;
import com.henry.service.UserService;
import com.henry.utils.CodeUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	
	Logger logger = Logger.getLogger(UserController.class);
	
	private UserService userService;
	private MailService mailService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	/**
	 * 验证邮箱是否存在 
	 */
	@RequestMapping(value = "/emailValidate", method = RequestMethod.GET)
	public @ResponseBody String emailValidate(User user) {
		//根据Email找User
		List<User> list = userService.selectUserListByEmail(user);
		//为空的 则没重复
		if(list.isEmpty()) {
			return "success";
		}
		
		return "fail";
	}
	
	/**
	 * 注册 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user) throws UnsupportedEncodingException {
		//产生激活码
		String activeCode = CodeUtil.createActiveCode(user.getEmail());
		user.setActiveCode(activeCode);
		userService.insert(user);
		//这里发邮件 获取id username
		//mailService.sendMail(user);
		return "redirect:/login.html";
	}
	
	//激活帐号
	@RequestMapping("/active/{id}")
	public String active(@PathVariable Integer id, @RequestParam String activeCode) {
		User user = new User(id);
		
		//根据id找User
		user = userService.selectUserListById(user).get(0);
		if(user.getActiveCode().equals(activeCode)) {
			user.setStatus(true);
			userService.updateStatusById(user);
			return "user/registered";
		}
		else {
			return "user/registerFail";
		}
	}
	
	//登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public boolean login(String email, String password, HttpSession session) {
		boolean flag = false;//用户不存在或者邮件或密码错误
		
		User user = new User(email);
		List<User> list = userService.selectUserListByEmail(user);
		if(list.isEmpty()) {
			return flag; //用户不存在
		}
		user = list.get(0);
		password = userService.encode(password, user.getSalt());
		if(user.getPassword().equals(password)) {
			flag = true;//登录成功
			session.setMaxInactiveInterval(60*60);//session一小时有效
			session.setAttribute("user", user);
		}
		return flag;
	}
	
	//退出登录
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/login.html";
	}
}