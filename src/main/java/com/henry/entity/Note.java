package com.henry.entity;

import java.util.Date;

public class Note {
    private Integer id;

    private String title;

    private String content;

    private Date createdTime;

    private Boolean authority;

    private User user;
    
    public Note() {}

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

    public String getContent() {
    	return content;
    }
    
    public void setContent(String content) {
    	this.content = content == null ? null : content.trim();
    }
    
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Boolean getAuthority() {
        return authority;
    }

    public void setAuthority(Boolean authority) {
        this.authority = authority;
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}