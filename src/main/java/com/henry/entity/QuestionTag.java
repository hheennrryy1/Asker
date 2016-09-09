package com.henry.entity;

/**
 * 中间表 记录Question和Tag的对应关系
 *
 */
public class QuestionTag {
	private Integer id;
	 
	private Question question;
	 
	private Tag tag;
	 
	public QuestionTag(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	};
}
