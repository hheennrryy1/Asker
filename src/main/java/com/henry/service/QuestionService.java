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
	
	//翻页
	public PageInfo<Question> selectAllByTime(Integer pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize, "created_time desc");
		List<Question> questions = mapper.selectAllByTime();
		PageInfo<Question> page = new PageInfo<>(questions);
		return page;
	}
	
	public PageInfo<Question> selectByTag(Integer pageNum, int pageSize, Integer id) {
		PageHelper.startPage(pageNum, pageSize, "created_time desc");
		List<Question> questions = mapper.selectByTag(id);
		PageInfo<Question> page = new PageInfo<>(questions);
		return page;
	}
	
	public PageInfo<Question> selectByTitle(Integer pageNum, int pageSize, String title) {
		PageHelper.startPage(pageNum, pageSize, "created_time desc");
		List<Question> questions = mapper.selectByTitle(title);
		PageInfo<Question> page = new PageInfo<>(questions);
		return page;
	}
	
	public int insert(Question question) {
    	return mapper.insert(question);
    }
	
}
