package com.henry.dao;

import com.henry.entity.Tag;

public interface TagMapper {
    int deleteById(Integer id);

    int insert(Tag tag);

    int insertSelective(Tag tag);

    Tag selectById(Integer id);
    
    Tag selectByName(String name);

    int updateByIdSelective(Tag tag);

    int updateById(Tag tag);
}