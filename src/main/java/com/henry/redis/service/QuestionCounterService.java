package com.henry.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.henry.redis.entity.QuestionCounter;

@Service
public class QuestionCounterService {
	
	private RedisTemplate<String, QuestionCounter> redisTemplate;
	
	private static StringBuilder sb = new StringBuilder("question:");
	
	@Autowired
	public void setRedisTemplate(RedisTemplate<String, QuestionCounter> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	//question:{id} hash 有clickCount属性
	public void insertHash(Integer questionId) {
		sb.append(questionId);
		redisTemplate.opsForHash().put(sb.toString(), "clickCount", "0");
	}
	
	//question:{id}:user:click 一个set记录点击过该答案的用户id
	public void insertSet(Integer questionId) {
		sb.append(questionId);
		sb.append(":user:click");
		redisTemplate.opsForSet().intersect(sb.toString(), "");
	}
	
	public int getClickCount(Integer questionId) {
		sb.append(questionId);
		return Integer.parseInt((String) redisTemplate.opsForHash().get(sb.toString(), "clickCount"));
	}
	
	//浏览数加一
	public void incrClickCount(Integer questionId) {
		sb.append(questionId);
		redisTemplate.opsForHash().increment(sb.toString(), "clickCount", 1);
	}
}