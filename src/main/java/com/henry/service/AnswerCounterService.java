package com.henry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.AnswerCounterMapper;
import com.henry.entity.AnswerCounter;

@Service
public class AnswerCounterService {
	
	public AnswerCounterMapper mapper;

	@Autowired
	public void setMapper(AnswerCounterMapper mapper) {
		this.mapper = mapper;
	}
	
	public AnswerCounter select(Integer answerId) {
		return mapper.select(answerId);
	}
	
	public int insert(Integer answerId) {
		return mapper.insert(answerId);
	}
	
	public int update(AnswerCounter counter) {
		return mapper.update(counter);
	}
}
