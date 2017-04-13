package com.henry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.henry.entity.Article;
import com.henry.entity.Question;
import com.henry.service.ArticleService;
import com.henry.service.QuestionService;

@Controller
@RequestMapping("/tag")
public class TagController {
	
	public static final int PAGE_SIZE = 20;
	
	private QuestionService quesService;
	private ArticleService articleService;
	
	@Autowired
	public void setQuesService(QuestionService quesService) {
		this.quesService = quesService;
	}

	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@RequestMapping("/{id}/questions")
	public ModelAndView questions(ModelAndView mav, @PathVariable Integer id,
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum) {
		PageInfo<Question> page = quesService.selectByTag(pageNum, PAGE_SIZE, id);
		mav.addObject("page", page);
		mav.setViewName("tag/questions");
		return mav;
	}
			
	@RequestMapping("/{id}/articles")
	public ModelAndView articles(ModelAndView mav, @PathVariable Integer id,
				@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum) {
		PageInfo<Article> page = articleService.selectByTag(pageNum, PAGE_SIZE, id);
		mav.addObject("page", page);
		mav.setViewName("tag/articles");
		return mav;
	}
	
}
