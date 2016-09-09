package com.henry.entity;

import java.util.List;

public class User {
    private Integer id;

    private String username;

    private String email;
    
    private String activeCode;

	private Boolean status = false; //默认没激活

    private String password;

    private String salt;

    private List<Question> questions;
    
    private List<Answer> answers;
    
    private String picture;
    
    private String city;
    
    private Boolean sex;//true为男 false为女
    
    private String company;

    private String position;

    private String signature;
    
    
    /*
    private List<Comment> comment;
    private List<Like> likes;
    */
    
    public User(){}

	public User(Integer id) {
		super();
		this.id = id;
	}

	public User(String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", activeCode=" + activeCode
				+ ", status=" + status + ", password=" + password + ", salt=" + salt + ", picture=" + picture
				+ ", city=" + city + ", sex=" + sex + ", company=" + company + ", position=" + position + ", signature="
				+ signature + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    
    public String getActiveCode() {
    	return activeCode;
    }
    
    public void setActiveCode(String activeCode) {
    	this.activeCode = activeCode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
    
    public List<Question> getQuestions() {
		return questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }
    
    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }
}