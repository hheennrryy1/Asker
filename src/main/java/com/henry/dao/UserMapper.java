package com.henry.dao;

import java.util.List;

import com.henry.entity.User;

public interface UserMapper {
    int deleteById(Integer id);

    int insertSelective(User user);
    
    List<User> selectUserList(User user);
    
    Integer selectLikesCount(Integer id);
    
    int updateByIdSelective(User user);
    
    int updateStatusById(User user);
}