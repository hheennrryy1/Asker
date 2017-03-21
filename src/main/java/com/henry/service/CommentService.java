package com.henry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.CommentMapper;
import com.henry.entity.Comment;

@Service
public class CommentService {
	
	private CommentMapper mapper;
	
	@Autowired
	public void setMapper(CommentMapper mapper) {
		this.mapper = mapper;
	}
	
	public int insert(Comment comment) {
		return mapper.insert(comment);
	}
	
	public List<Comment> selectByAnswerId(Integer answerId) {
		return mapper.selectByAnswerId(answerId);
	}
}
