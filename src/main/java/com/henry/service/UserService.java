package com.henry.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henry.dao.UserMapper;
import com.henry.entity.Question;
import com.henry.entity.User;
import com.henry.utils.CodeUtil;

@Service
public class UserService {
	
	private UserMapper mapper;
	
	@Autowired
	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}
	
	//这个方法用于检测用户存不存在，不存在就转到404页面
	public List<User> selectUserListById(User user) {
		List<User> list =  mapper.selectUserList(user);
		if(list.isEmpty()) {
			//没找到用户 抛异常
			throw new NullPointerException();
		}
		return list;
	}
	
	public List<User> selectUserListByEmail(User user) {
		return mapper.selectUserList(user);
	}
	
	public Integer selectLikesCount(Integer id) {
		return mapper.selectLikesCount(id);
	}
	
	public int insert(User user) throws UnsupportedEncodingException {
		String password = user.getPassword();
		String salt = CodeUtil.generateSalt();
		user.setSalt(salt);
		password = encode(password, salt);//加salt再sha512
		user.setPassword(password);
		return mapper.insertSelective(user);
	}
	
	public int updateByIdSelective(User user) {
		return mapper.updateByIdSelective(user);
	}
	
	public int updateStatusById(User user) {
		return mapper.updateStatusById(user);
	}
	
	public String encode(String password, String salt) {
		return CodeUtil.encode(password, salt);
	}
}
