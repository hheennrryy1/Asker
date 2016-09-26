package com.henry.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.henry.redis.entity.QuestionCounter;

@Service
public class QuestionCounterService {
	
	private RedisTemplate<String, QuestionCounter> redisTemplate;
	
	@Autowired
	public void setRedisTemplate(RedisTemplate<String, QuestionCounter> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	public void insert(Integer questionId) {
		//redisTemplate.opsForHash().put("counter:question:" + questionId, "count", 0);
		//redisTemplate.opsForHash().put("counter:question:" + questionId, "c", 0);
		redisTemplate.opsForHash().delete("counter:question:1", "c");
	}
}
