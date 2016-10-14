package com.henry.entity;

import java.util.Date;
import java.util.List;

import com.henry.redis.entity.QuestionCounter;

public class Question {
	private Integer id;

    private String title;

    private Date createdTime;

    private User user;

    private String content;
    
    private List<Tag> tags;
    
    private QuestionCounter questionCounter;
    
    public Question(){};
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public QuestionCounter getQuestionCounter() {
		return questionCounter;
	}

	public void setQuestionCounter(QuestionCounter questionCounter) {
		this.questionCounter = questionCounter;
	}
}