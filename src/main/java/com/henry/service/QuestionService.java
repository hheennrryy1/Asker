package com.henry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henry.dao.QuestionMapper;
import com.henry.entity.Question;

@Service
public class QuestionService {
	
	private QuestionMapper mapper;
	
	@Autowired
    public void setMapper(QuestionMapper mapper) {
		this.mapper = mapper;
	}
	
	public Question selectById(Integer id) {
		return mapper.selectById(id);
	}
	
	public PageInfo<Question> selectByUserId(Integer userId, int pageSize) {
		PageHelper.startPage(1, pageSize, "created_time desc");
		List<Question> questions = mapper.selectByUserId(userId);
		PageInfo<Question> page = new PageInfo<>(questions);
		return page;
	}
	
	public int insert(Question question) {
    	return mapper.insert(question);
    }
	
}
