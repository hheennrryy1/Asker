package com.henry.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.SyslogWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import com.henry.entity.Article;
import com.henry.entity.Tag;
import com.henry.service.TagService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	Logger logger = Logger.getLogger(ArticleController.class);
	
	private TagService tagService;
	
	@Autowired
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String toWrite() {
		return "article/write";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Article article, String tagStr) {
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
		
		
		return "article/write";
	}
}
