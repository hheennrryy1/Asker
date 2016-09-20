package com.henry.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henry.entity.Answer;
import com.henry.entity.Question;
import com.henry.entity.User;
import com.henry.service.AnswerCounterService;
import com.henry.service.AnswerService;

@Controller
@RequestMapping("/answer")
public class AnswerController {
	
	Logger logger = Logger.getLogger(AnswerController.class);
	
	private AnswerService answerService;
	private AnswerCounterService counterService;

	@Autowired
	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}
	
	@Autowired
	public void setCounterService(AnswerCounterService counterService) {
		this.counterService = counterService;
	}
	
	//添加答案
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Answer answer, HttpSession session, Integer questionId) {
		User user = (User) session.getAttribute("user");
		
		answer.setLastUpdated(new Date());
		answer.setUser(user);
		Question q = new Question();
		q.setId(questionId);
		answer.setQuestion(q);
		answerService.insert(answer);
		counterService.insert(answer.getId());
		return "redirect:/question/" + questionId + "?pageNum=1";
	}

	//更新答案
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(Answer answer) {
		answer.setLastUpdated(new Date());
		int flag = answerService.updateByIdSelective(answer);
		Map<String, Object> map = new HashMap<>();
		map.put("flag", flag);
		return map;
	}
}