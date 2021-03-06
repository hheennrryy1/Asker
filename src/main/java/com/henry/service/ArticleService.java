package com.henry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	
	public PageInfo<Article> selectAllByTime(Integer pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize, "created_time desc");
		List<Article> articles = mapper.selectAllByTime();
		PageInfo<Article> page = new PageInfo<>(articles);
		return page;
	}
	
	public PageInfo<Article> selectByTag(Integer pageNum, int pageSize, Integer id) {
		PageHelper.startPage(pageNum, pageSize, "created_time desc");
		List<Article> articles = mapper.selectByTag(id);
		PageInfo<Article> page = new PageInfo<>(articles);
		return page;
	}
	
	public Article selectById(Integer id) {
		return mapper.selectById(id);
	}
	
	public List<Article> selectByColumnsId(Integer id) {
		return mapper.selecyByColumnsId(id);
	}
	
	public PageInfo<Article> selectByTitle(Integer pageNum, int pageSize, String title) {
		PageHelper.startPage(pageNum, pageSize, "created_time desc");
		List<Article> articles = mapper.selectByTitle(title);
		PageInfo<Article> page = new PageInfo<>(articles);
		return page;
	}
	
	public int updateById(Article article) {
		return mapper.updateById(article);
	}
	
	public int delete(Integer id) {
		return mapper.delete(id); 
	}
}
