package com.henry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.ArticleTagMapper;
import com.henry.entity.ArticleTag;

@Service
public class ArticleTagService {
	
	private ArticleTagMapper mapper;
	
	@Autowired
	public void setMapper(ArticleTagMapper mapper) {
		this.mapper = mapper;
	}

	public int insert(ArticleTag articleTag) {
		return mapper.insert(articleTag);
	}
}
