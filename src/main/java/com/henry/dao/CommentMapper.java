package com.henry.dao;

import java.util.List;

import com.henry.entity.Comment;

public interface CommentMapper {
	
	int insert(Comment comment);
	
	List<Comment> selectByAnswerId(Integer answerId);
}