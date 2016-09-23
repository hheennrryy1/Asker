package com.henry.dao;

import com.henry.entity.AnswerCounter;

public interface AnswerCounterMapper {
	
	AnswerCounter select(Integer answerId);
	
	int insert(Integer answerId);
	
	int update(AnswerCounter counter);
}