package com.henry.redis.entity;

import java.io.Serializable;

public class QuestionCounter implements Serializable {
	
	private int clickCount;
	
	public QuestionCounter() {}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	};
}
