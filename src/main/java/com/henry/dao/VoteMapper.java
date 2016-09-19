package com.henry.dao;

import com.henry.entity.Vote;
import com.henry.entity.VoteKey;

public interface VoteMapper {
    int deleteById(VoteKey key);

    int insert(Vote vote);

    Vote selectById(VoteKey key);
    
    int updateById(Vote vote);
}