package com.henry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.QuestionTagMapper;
import com.henry.entity.QuestionTag;

@Service
public class QuestionTagService {
	
	private QuestionTagMapper mapper;
	
	@Autowired
	public void setMapper(QuestionTagMapper mapper) {
		this.mapper = mapper;
	}

	public int insert(QuestionTag qt) {
		return mapper.insert(qt);
	}
}
