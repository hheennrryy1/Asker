package com.henry.entity;

import java.util.Date;

public class Answer {
	
    private Integer id;

    private Date lastUpdated;

    private User user;
    
    private Question question;

    private String content;
    
    //不持久化，作为当前用户是否true赞过，false反对过,null则没点过
    private Boolean liked;

    public Answer(){};
    
    public Answer(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", lastUpdated=" + lastUpdated + ", user=" + user + ", question=" + question
				+ ", content=" + content + ", liked=" + liked + "]";
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

	public Boolean getLiked() {
		return liked;
	}

	public void setLiked(Boolean liked) {
		this.liked = liked;
	}
}