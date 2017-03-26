package com.henry.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.henry.entity.Article;
import com.henry.entity.ArticleTag;
import com.henry.entity.Columns;
import com.henry.entity.Tag;
import com.henry.entity.User;
import com.henry.service.ArticleService;
import com.henry.service.ArticleTagService;
import com.henry.service.ColumnsService;
import com.henry.service.TagService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	Logger logger = Logger.getLogger(ArticleController.class);
	
	private ArticleService articleService;
	private TagService tagService;
	private ArticleTagService articleTagService;
	private ColumnsService columnsService; 
	
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@Autowired
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}

	@Autowired
	public void setArticleTagService(ArticleTagService articleTagService) {
		this.articleTagService = articleTagService;
	}
	
	@Autowired
	public void setColumnsService(ColumnsService columnsService) {
		this.columnsService = columnsService;
	}
	
	
	@ModelAttribute
	public User getUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}

	//转向到写文章的页面，写查出用户的所有专栏
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public ModelAndView toWrite(@ModelAttribute User user, ModelAndView mav) {
		List<Columns> columns = columnsService.selectByUserId(user.getId());
		mav.addObject("columns", columns);
		//页面显示出来
		mav.setViewName("article/write");
		return mav; 
	}
	
	//写文章，存article和tag的关系
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Article article, String tagStr, @ModelAttribute User user) {
		String []tagsName = tagStr.split(",");
		//存放每个问题的tag
		List<Tag> tags = new ArrayList<>();
		
		//用tag的name找到tag的id
		for(String name : tagsName) {
			Tag tag = tagService.selectByName(name);
			//如果tag不存在，则新增这个tag
			if(tag == null) {
				tag = new Tag(name);
				tagService.insert(tag);
			}
			tags.add(tag);
		}
		//这里当作只有一个专栏
		Columns columns = columnsService.selectByUserId(user.getId()).get(0);
		article.setColumns(columns);
		article.setCreatedTime(new Date());
		article.setUser(user);
		articleService.insert(article);
		
		ArticleTag at = new ArticleTag();
		at.setArticle(article);
		for(Tag t : tags) {
			at.setTag(t);
			articleTagService.insert(at);
		}
		
		return "redirect:/article/" + article.getId();
	}
	
	//转向到文章页面
	@RequestMapping("/{articleId}")
	public ModelAndView article(@PathVariable Integer articleId, ModelAndView mav) {
		articleService.selectById(articleId);
		Article article = articleService.selectById(articleId);
		if(article == null) {
			throw new NullPointerException();
		}
		mav.addObject("article", article);
		//写view
		mav.setViewName("article/article");
		return mav;
	}
	
	@RequestMapping("/update/{articleId}")
	public ModelAndView toUpdate(@PathVariable Integer articleId, ModelAndView mav, HttpSession session) {
		User user = (User)session.getAttribute("user");
		
		Article article = articleService.selectById(articleId);
		if(user.getId() != article.getUser().getId()) {
			return null;
		}
		mav.addObject("article", article);
		mav.setViewName("article/update");
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Article article) {
		articleService.updateById(article);
		return "redirect:/article/" + article.getId();
	}
	
	@RequestMapping("/delete/{id}")
	public @ResponseBody int delete(@PathVariable Integer id) {
		return articleService.delete(id);
	}
}
