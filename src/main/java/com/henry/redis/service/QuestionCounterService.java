package com.henry.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class QuestionCounterService {
	
	private RedisTemplate<Object, Object> redisTemplate;
	
	@Autowired
	public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	//question:{id} hash 有clickCount属性
	public void hset(Integer questionId) {
		StringBuilder sb = new StringBuilder("question:");
		sb.append(questionId);
		redisTemplate.opsForHash().put(sb.toString(), "clickCount", "0");
	}
	
	//question:{id}:user:click 一个set记录点击过该答案的用户id
	//将用户的id加入问题的set
	public void sadd(Integer questionId, Integer userId) {
		StringBuilder sb = new StringBuilder("question:");
		sb.append(questionId);
		sb.append(":user:click");
		if(userId!=null) {
			redisTemplate.opsForSet().add(sb.toString(), userId.toString());
		}
		redisTemplate.opsForSet().add(sb.toString(), "");
	}
	
	//判断用户有没有浏览过某问题
	public boolean isMember(Integer questionId, Integer userId) {
		StringBuilder sb = new StringBuilder("question:");
		sb.append(questionId);
		sb.append(":user:click");
		return redisTemplate.opsForSet().isMember(sb.toString(), userId.toString());
	}
	
	//得到浏览数
	public int getClickCount(Integer questionId) {
		StringBuilder sb = new StringBuilder("question:");
		sb.append(questionId);
		return Integer.parseInt((String) redisTemplate.opsForHash().get(sb.toString(), "clickCount"));
	}
	
	//浏览数加一
	public void incrClickCount(Integer questionId) {
		StringBuilder sb = new StringBuilder("question:");
		sb.append(questionId);
		redisTemplate.opsForHash().increment(sb.toString(), "clickCount", 1);
	}
}