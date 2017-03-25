package com.henry.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.henry.entity.Note;
import com.henry.entity.User;
import com.henry.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	private NoteService noteService;
	
	@Autowired
	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@ModelAttribute
	public User getUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}

	@RequestMapping("/write")
	public String toWrite() {
		return "note/write";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Note note, @ModelAttribute User user) {
		note.setCreatedTime(new Date());
		note.setUser(user);
		noteService.insert(note);
		return "";
	}
}
