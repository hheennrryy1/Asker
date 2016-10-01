package com.henry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henry.dao.AnswerMapper;
import com.henry.entity.Answer;

@Service
public class AnswerService {
	
	private AnswerMapper mapper;

	@Autowired
	public void setMapper(AnswerMapper mapper) {
		this.mapper = mapper;
	}
	
	public int insert(Answer answer) {
		return mapper.insert(answer);
	}
	
	//选择单个答案
	public Answer selectOneAnswer (Integer answerId, Integer questionId) {
		return mapper.selectOneAnswer(answerId, questionId);
	}
	
	//选择问题的答案，并分页
	public PageInfo<Answer> selectByQuestionId(Integer questionId, Integer pageNum, int pageSize) {
		//pageNum,pageSize 每页显示5条
		PageHelper.startPage(pageNum, pageSize);
		PageHelper.startPage(pageNum, pageSize);
		List<Answer> answers = mapper.selectByIds(questionId, null);
		PageInfo<Answer> pageInfo = new PageInfo<Answer>(answers);
		return pageInfo;
	}
	
	//这个方法用来判断用户是否已经回答过某个问题
	public List<Answer> selectByQidAndUid(Integer questionId, Integer userId) {
		return mapper.selectByIds(questionId, userId);
	}
	
	//选择用户的回答
	public PageInfo<Answer> selectByUserId(Integer userId, int pageSize) {
		String regex1 = "\\&[a-zA-Z]{0,9};";
		String regex2 = "<[^>]*>"; 
		
		PageHelper.startPage(1, pageSize, "last_updated desc");
		List<Answer> answers = mapper.selectByUserId(userId);
		for(Answer a : answers) {
			String content = a.getContent().replaceAll(regex1, "").replaceAll(regex2, "");
			if(50 <= content.length()) {
				content = content.substring(0, 49) + "...";
			}
			a.setContent(content);
		}
		PageInfo<Answer> page = new PageInfo<>(answers);
		return page;
	}
	
	public int updateByIdSelective(Answer answer) {
		return mapper.updateByIdSelective(answer);
	}
}
