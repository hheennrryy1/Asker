package com.henry.dao;

import java.util.List;

import com.henry.entity.Note;

public interface NoteMapper {
	
	int insert(Note note);
	
	List<Note> selectByUserId(Integer userId);
	
	Note selectById(Integer id);
	
	int delete(Integer id);
}
