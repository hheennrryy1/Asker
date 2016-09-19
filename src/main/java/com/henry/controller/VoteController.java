package com.henry.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henry.entity.Answer;
import com.henry.entity.User;
import com.henry.entity.Vote;
import com.henry.entity.VoteKey;
import com.henry.service.VoteService;

@Controller
public class VoteController {
	
	Logger logger = Logger.getLogger(VoteController.class);
	
	private VoteService voteService;
	
	@Autowired
	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}
	
	@ModelAttribute
	public User getUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}
	
	//投票 赞同或者反对
	@RequestMapping("/vote")
	@ResponseBody
	public String vote(@RequestParam("answerId") Integer answerId,
						Vote vote,//vote的mode已经set了
						@ModelAttribute User user) {
		vote.setUser(user);
		vote.setAnswer(new Answer(answerId));
		voteService.insert(vote);
		return "";
	}
	
	//取消赞同或者反对
	@RequestMapping("/unvote")
	@ResponseBody
	public String unvote(@RequestParam("answerId") Integer answerId, @ModelAttribute User user) {
		logger.info("unvote");
		VoteKey key = new VoteKey();
		key.setUser(user);
		key.setAnswer(new Answer(answerId));
		voteService.delete(key);
		return "";
	}
	
	@RequestMapping("/updateVote")
	@ResponseBody
	public String updateVote(@RequestParam("answerId") Integer answerId,
								Vote vote,//vote的mode已经set了
								@ModelAttribute User user) {
		vote.setUser(user);
		vote.setAnswer(new Answer(answerId));
		voteService.updateById(vote);
		//测试
		return "";
	}
}
