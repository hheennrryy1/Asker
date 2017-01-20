package com.henry.entity;

/**
 * 中间表 记录Article和Tag的对应关系 
 *
 */
public class ArticleTag {
	private Integer id;
	
	private Article article;
	
	private Tag tag;
	
	public ArticleTag() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
