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
import com.henry.entity.AnswerCounter;
import com.henry.entity.User;
import com.henry.entity.Vote;
import com.henry.entity.VoteKey;
import com.henry.service.AnswerCounterService;
import com.henry.service.VoteService;

@Controller
public class VoteController {
	
	Logger logger = Logger.getLogger(VoteController.class);
	
	private VoteService voteService;
	private AnswerCounterService counterService;
	
	@Autowired
	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}
	
	@Autowired
	public void setCounterService(AnswerCounterService counterService) {
		this.counterService = counterService;
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
		
		//获得该答案的投票计数器
		AnswerCounter counter = counterService.select(answerId);
		if(vote.getMode()) {
			//赞同数加一
			counter.setLikesCount(counter.getLikesCount() + 1);
		}
		else if(!vote.getMode()) {
			//反对数加一
			counter.setDislikesCount(counter.getDislikesCount() + 1);
		}
		counterService.update(counter);
		return "";
	}
	
	//取消赞同或者反对
	@RequestMapping("/unvote")
	@ResponseBody
	public String unvote(@RequestParam("answerId") Integer answerId, @RequestParam("mode") Boolean mode,
							@ModelAttribute User user) {
		VoteKey key = new VoteKey();
		key.setUser(user);
		key.setAnswer(new Answer(answerId));
		voteService.delete(key);
		
		//获得该答案的投票计数器
		AnswerCounter counter = counterService.select(answerId);
		logger.info(counter);
		//赞同数减一
		if(mode) {
			counter.setLikesCount(counter.getLikesCount() - 1);
		}
		//反对数减一
		else if(!mode) {
			counter.setDislikesCount(counter.getDislikesCount() - 1);
		}
		counterService.update(counter);
		return "";
	}
	
	//已经点了赞然后点反对 或者 已经点了反对然后点赞
	@RequestMapping("/updateVote")
	@ResponseBody
	public String updateVote(@RequestParam("answerId") Integer answerId,
								Vote vote,//vote的mode已经set了
								@ModelAttribute User user) {
		vote.setUser(user);
		vote.setAnswer(new Answer(answerId));
		voteService.updateById(vote);
		
		AnswerCounter counter = counterService.select(answerId);
		//已经点了赞然后点反对
		if(!vote.getMode()) {
			counter.setLikesCount(counter.getLikesCount() - 1);
			counter.setDislikesCount(counter.getDislikesCount() + 1);
		}
		//已经点了反对然后点赞
		else if(vote.getMode()) {
			counter.setDislikesCount(counter.getDislikesCount() - 1);
			counter.setLikesCount(counter.getLikesCount() + 1);
		}
		counterService.update(counter);
		return "";
	}
}
