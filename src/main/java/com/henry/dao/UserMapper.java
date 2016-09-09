package com.henry.dao;

import java.util.List;

import com.henry.entity.User;

public interface UserMapper {
    int deleteById(Integer id);

    int insert(User user);

    int insertSelective(User user);
    
    User selectUserQuestions(User user);

    List<User> selectUserList(User user);

    int updateByIdSelective(User user);
    
    int updateStatusById(User user);
    
    int updateById(User user);
}