package com.henry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.NoteMapper;
import com.henry.entity.Note;

@Service
public class NoteService {
	
	private NoteMapper mapper;
	
	@Autowired
	public void setMapper(NoteMapper mapper) {
		this.mapper = mapper;
	}

	public int insert(Note note) {
		return mapper.insert(note); 
	}
	
	public List<Note> selectByUserId(Integer userId) {
		return mapper.selectByUserId(userId);
	}
	
	public Note selectById(Integer id) {
		return mapper.selectById(id);
	}

	public int delete(Integer id) {
		return mapper.delete(id);
	}
	
	public int update(Note note) {
		return mapper.update(note);
	}
}
