package com.henry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.ArticleMapper;
import com.henry.entity.Article;

@Service
public class ArticleService {
	
	private ArticleMapper mapper;

	@Autowired
	public void setMapper(ArticleMapper mapper) {
		this.mapper = mapper;
	}
	
	public int insert(Article article) {
		return mapper.insert(article);
	}
}
