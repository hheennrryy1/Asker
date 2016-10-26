package com.henry.dao;

import com.henry.entity.Columns;

public interface ColumnsMapper {
    int deleteById(Integer id);

    int insert(Columns columns);

    Columns selectById(Integer id);

    int updateByIdSelective(Columns columns);
}