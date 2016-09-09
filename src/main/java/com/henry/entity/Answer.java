package com.henry.entity;

import java.util.Date;

public class Answer {
	
    private Integer id;

    private Date lastUpdated;

    private User user;
    
    private Question question;

    private String content;

    public Answer(){};
    
    @Override
	public String toString() {
		return "Answer [id=" + id + ", lastUpdated=" + lastUpdated + ", user=" + user + ", question=" + question
				+ ", content=" + content + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}