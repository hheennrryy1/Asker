package com.henry.dao;

import java.util.List;

import com.henry.entity.Question;

public interface QuestionMapper {
	Question selectById(Integer id);
	
	List<Question> selectByUserId(Integer userId);
	
	List<Question> selectAllByTime();
	
	List<Question> selectByTag(Integer id);

	List<Question> selectByTitle(String title);
	
    int deleteById(Integer id);

    int insert(Question question);

    int updateByIdSelective(Question question);
}