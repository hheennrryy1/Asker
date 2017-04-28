package com.henry.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	//记笔记
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Note note, @ModelAttribute User user) {
		note.setCreatedTime(new Date());
		note.setUser(user);
		noteService.insert(note);
		return "redirect:/note/" + note.getId();
	}
	
	//笔记页面
	@RequestMapping("/{noteId}")
	public ModelAndView note(@PathVariable Integer noteId, ModelAndView mav, @ModelAttribute User user) {
		Note note = noteService.selectById(noteId);
		if(note==null) {
			throw new NullPointerException();
		}
		//如果是私密笔记 验证是否为本用户
		if(!note.getAuthority() && !(user.getId().equals(note.getUser().getId()))) {
			return null;
		}
		mav.addObject("note", note);
		mav.setViewName("note/note");
		return mav;
	}
	
	//删除笔记
	@RequestMapping("/delete/{id}")
	public @ResponseBody int delete(@PathVariable Integer id) {
		return noteService.delete(id);
	}
	
	@RequestMapping("/update/{id}")
	public ModelAndView toUpdate(ModelAndView mav, @PathVariable Integer id, HttpSession session) {
		User user = (User)session.getAttribute("user");
		
		Note note = noteService.selectById(id);
		if(user.getId() != note.getUser().getId()) {
			return null;
		}
		mav.addObject("note", note);
		mav.setViewName("note/update");
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Note note) {
		noteService.update(note);
		return "redirect:/note/" + note.getId();
	}
}
