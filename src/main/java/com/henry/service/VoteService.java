package com.henry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.VoteMapper;
import com.henry.entity.Vote;

@Service
public class VoteService {
	
	private VoteMapper mapper;

	@Autowired
	public void setMapper(VoteMapper mapper) {
		this.mapper = mapper;
	}
	
	public int insert(Vote vote) {
		return mapper.insert(vote);
	}
}
