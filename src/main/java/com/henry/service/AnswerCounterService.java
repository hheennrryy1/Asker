package com.henry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.AnswerCounterMapper;

@Service
public class AnswerCounterService {
	
	public AnswerCounterMapper mapper;

	@Autowired
	public void setMapper(AnswerCounterMapper mapper) {
		this.mapper = mapper;
	}
	
	public int insert(Integer answerId) {
		return mapper.insert(answerId);
	}
}
