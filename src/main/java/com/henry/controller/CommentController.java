package com.henry.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.henry.entity.Answer;
import com.henry.entity.Comment;
import com.henry.entity.User;
import com.henry.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	private CommentService commentService;
	
	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@ModelAttribute
	public User getUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Comment comment, @ModelAttribute User user, Integer modalAnswerId) {
		comment.setAnswer(new Answer(modalAnswerId));
		comment.setUser(user);
		comment.setCreatedTime(new Date());
		commentService.insert(comment);
		return "";
	}


}
