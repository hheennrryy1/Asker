package com.henry.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.SyslogWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.henry.entity.Article;
import com.henry.entity.Tag;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	Logger logger = Logger.getLogger(ArticleController.class);
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String toWrite() {
		return "article/write";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Article article, String tagStr) {
		String []tagsName = tagStr.split(",");
		//存放每个问题的tag
		List<Tag> tags = new ArrayList<>();
		
		tags.forEach(n -> System.out.println(n.getName()));
		return "article/write";
	}
}
