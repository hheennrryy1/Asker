package com.henry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.henry.entity.Article;
import com.henry.entity.Question;
import com.henry.service.ArticleService;
import com.henry.service.QuestionService;

@Controller
public class JumpController {
	
	private QuestionService questionService;
	private ArticleService articleService;
	
	public static final int PAGE_SIZE = 20;
	
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
		PageInfo<Question> qpage = questionService.selectAllByTime(1, PAGE_SIZE);
		mav.addObject("qpage", qpage);
		PageInfo<Article> apage = articleService.selectAllByTime(1, PAGE_SIZE);
		mav.addObject("apage", apage);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/questions")
	public ModelAndView questions(ModelAndView mav, 
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum) {
		PageInfo<Question> page = questionService.selectAllByTime(pageNum, PAGE_SIZE);
		mav.addObject("page", page);
		
		mav.setViewName("question/questions");
		return mav;
	}
	
	@RequestMapping("/articles")
	public ModelAndView articles(ModelAndView mav, 
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum) {
		PageInfo<Article> page = articleService.selectAllByTime(pageNum, PAGE_SIZE);
		mav.addObject("page", page);
		
		mav.setViewName("article/articles");
		return mav;
	}
	
	@RequestMapping("/search")
	public ModelAndView search(ModelAndView mav, String keyWord, String type, 
				@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum) {
		mav.addObject("keyWord", keyWord);//这里不行
		if("question".equals(type)) {
			PageInfo<Question> page = questionService.selectByTitle(1, PAGE_SIZE, keyWord);
			mav.addObject("page", page);
			mav.setViewName("question/search");
		}
		else if("article".equals(type)) {
			PageInfo<Article> page = articleService.selectByTitle(1, PAGE_SIZE, keyWord);
			mav.addObject("page", page);
			mav.setViewName("article/search");
		}
		return mav;
	}
}
