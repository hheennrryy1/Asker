package com.henry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.TagMapper;
import com.henry.entity.Tag;

@Service
public class TagService {
	
	private TagMapper mapper;
	
	@Autowired
	public void setMapper(TagMapper mapper) {
		this.mapper = mapper;
	}

	public int insert(Tag tag) {
		return mapper.insertSelective(tag);
	}
	
	public Tag selectByName(String name) {
		return mapper.selectByName(name);
	}
}
