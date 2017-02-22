package com.henry.dao;

import java.util.List;

import com.henry.entity.Columns;

public interface ColumnsMapper {
    int deleteById(Integer id);

    int insert(Columns columns);

    Columns selectById(Integer id);
    
    List<Columns> selectByUserId(Integer userId);

    int updateByIdSelective(Columns columns);
    
    Columns selecyByColumnsId(Integer id);
}