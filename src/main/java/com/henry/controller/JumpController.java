package com.henry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.henry.entity.Article;
import com.henry.entity.Question;
import com.henry.service.ArticleService;
import com.henry.service.QuestionService;

@Controller
public class JumpController {
	
	private QuestionService questionService;
	private ArticleService articleService;
	
	@Autowired
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	//转向到首页
	@RequestMapping("/index")
	public ModelAndView toIndex(ModelAndView mav) {
		List<Question> questions = questionService.selectByTime();
		mav.addObject("questions", questions);
		List<Article> articles = articleService.selectByTime();
		mav.addObject("articles", articles);
		mav.setViewName("index");
		return mav;
	}
}
