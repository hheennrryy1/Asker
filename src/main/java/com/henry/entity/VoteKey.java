package com.henry.entity;

//投票的联合主键
public class VoteKey {
    private User user;
    
    private Answer answer;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
}