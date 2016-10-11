package com.henry.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.henry.entity.Answer;
import com.henry.entity.AnswerCounter;
import com.henry.entity.Question;
import com.henry.entity.User;
import com.henry.service.AnswerCounterService;
import com.henry.service.AnswerService;
import com.henry.service.QuestionService;
import com.henry.service.UserService;

@Controller
@RequestMapping("/user")
public class PersonalPageController {
	
	Logger logger = Logger.getLogger(PersonalPageController.class);
	
	public static final int PERSONAL_PAGE_SIZE = 5;
	public static final int ASKS_PAGE_SIZE = 10;
	
	private UserService userService;
	private QuestionService questionService;
	private AnswerService answerService;
	private AnswerCounterService answerCounterService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@Autowired
	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}
	
	@Autowired
	public void setAnswerCounterService(AnswerCounterService answerCounterService) {
		this.answerCounterService = answerCounterService;
	}

	@ModelAttribute
	public User getSessionUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}

	//转向到个人主页，先准备数据
	@RequestMapping("/{uid}")
	public ModelAndView personalPage(@PathVariable("uid") Integer id, ModelAndView mav, @ModelAttribute User user) {
		boolean isMyself = false;
		if(user.getId().equals(id)) {
			isMyself = true;
		}
		//判断是不是用户自己进入个人主页
		mav.addObject("isMyself", isMyself);
		
		User u = new User(id);
		List<User> list = userService.selectUserListById(u);
		mav.addObject("personalPageUser", list.get(0));
		
		Integer likesCount = userService.selectLikesCount(id);
		mav.addObject("likesCount", likesCount);
		
		PageInfo<Question> qPage = questionService.selectByUserId(id, PERSONAL_PAGE_SIZE);
		mav.addObject("qPage", qPage);
		
		PageInfo<Answer> aPage = answerService.selectByUserId(id, PERSONAL_PAGE_SIZE);
		
		//找到赞同数 和 反对数
		for(Answer a : aPage.getList()) {
			AnswerCounter counter = answerCounterService.select(a.getId());
			a.setAnswerCounter(counter);
		}
		mav.addObject("aPage", aPage);
		
		mav.setViewName("user/personalPage");
		return mav;
	}

	//转向到修改用户资料的页面
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String toEdit() {
		return "user/edit";
	}
	
	//修改用户资料
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute User user, HttpSession session) 
									throws IllegalStateException, IOException {
		if(!multipartFile.isEmpty()) {
			long time = System.currentTimeMillis();
			String timeStr = String.valueOf(time);
			String[] originalFilename = multipartFile.getOriginalFilename().split("\\.");
			String filename = timeStr + "." + originalFilename[1];
			
			//注意路径 Linux要修改
			StringBuilder path = new StringBuilder();
			path.append("E:")
				.append(File.separator)
				.append("workspace")
				.append(File.separator)
				.append("AskerPicture")
				.append(File.separator)
				.append(filename);
			
			File file = new File(path.toString());
			user.setPicture("/picture/" + filename);
			
			multipartFile.transferTo(file);
		}
		
		userService.updateByIdSelective(user);
		session.setAttribute("user", user);
		
		return "redirect:/user/" + user.getId();
	}
	
	//转向到查看用户所有提问页面，先准备数据
	@RequestMapping("/{uid}/asks")
	public ModelAndView asks(@PathVariable("uid") Integer id, ModelAndView mav, @ModelAttribute User user) {
		boolean isMyself = false;
		if(user.getId().equals(id)) {
			isMyself = true;
		}
		//判断是不是用户自己进入个人主页
		mav.addObject("isMyself", isMyself);
		
		User u = new User(id);
		List<User> list = userService.selectUserListById(u);
		mav.addObject("personalPageUser", list.get(0));
		
		PageInfo<Question> qPage = questionService.selectByUserId(id, ASKS_PAGE_SIZE);
		mav.addObject("qPage", qPage);
		
		mav.setViewName("user/asks");
		return mav;
	}
	
	//转向到查看用户所有回答页面，先准备数据
	@RequestMapping("/{uid}/answers")
	public ModelAndView answers(@PathVariable("uid") Integer id, ModelAndView mav, @ModelAttribute User user) {
		boolean isMyself = false;
		if(user.getId().equals(id)) {
			isMyself = true;
		}
		//判断是不是用户自己进入个人主页
		mav.addObject("isMyself", isMyself);
		
		User u = new User(id);
		List<User> list = userService.selectUserListById(u);
		mav.addObject("personalPageUser", list.get(0));
		
		PageInfo<Answer> aPage = answerService.selectByUserId(id, ASKS_PAGE_SIZE);
		//找到赞同数 和 反对数
		for(Answer a : aPage.getList()) {
			AnswerCounter counter = answerCounterService.select(a.getId());
			a.setAnswerCounter(counter);
		}
		mav.addObject("aPage", aPage);
		
		mav.setViewName("user/answers");
		return mav;
	}
}