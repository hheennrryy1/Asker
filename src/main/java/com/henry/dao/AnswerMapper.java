package com.henry.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.henry.entity.Answer;

public interface AnswerMapper {
	
	Answer selectOneAnswer(@Param(value = "answerId") Integer answerId, @Param(value = "questionId")Integer questionId);
	
	List<Answer> selectByIds(@Param(value = "questionId") Integer questionId, @Param(value = "userId")Integer userId);
	
	List<Answer> selectByUserId(Integer userId);
	
    int deleteById(Integer id);

    int insert(Answer answer);

    int updateByIdSelective(Answer answer);
}