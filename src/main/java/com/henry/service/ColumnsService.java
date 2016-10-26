package com.henry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.ColumnsMapper;
import com.henry.entity.Columns;

@Service
public class ColumnsService {
	
	private ColumnsMapper mapper;
	
	@Autowired
	public void setMapper(ColumnsMapper mapper) {
		this.mapper = mapper;
	}

	public int insert(Columns columns) {
		return mapper.insert(columns); 
	}
}
