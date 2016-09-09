package com.henry.dao;

import com.henry.entity.QuestionTag;

public interface QuestionTagMapper {
    int deleteById(Integer id);

    int insert(QuestionTag qt);

    int insertSelective(QuestionTag qt);

    QuestionTag selectById(Integer id);

    int updateByIdSelective(QuestionTag qt);

    int updateById(QuestionTag qt);
}