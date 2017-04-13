package com.henry.dao;

import java.util.List;

import com.henry.entity.Article;

public interface ArticleMapper {
	
	int insert(Article article);
	
	List<Article> selectAllByTime();
	
	List<Article> selectByTag(Integer id);
	
	Article selectById(Integer id);
	
	List<Article> selecyByColumnsId(Integer id);
	
	int updateById(Article article);
	
	int delete(Integer id);
}