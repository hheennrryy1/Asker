package com.henry.dao;

import java.util.List;

import com.henry.entity.Article;

public interface ArticleMapper {
	
	int insert(Article article);
	
	List<Article> selectByTime();
	
	Article selectById(Integer id);
	
}