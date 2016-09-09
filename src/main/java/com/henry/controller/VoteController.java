package com.henry.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henry.service.VoteService;

@Controller
@RequestMapping("/vote")
public class VoteController {
	
	Logger logger = Logger.getLogger(VoteController.class);
	
	private VoteService voteService;
	
	@Autowired
	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String vote(@RequestParam(required = false) String test) {
		logger.info(test);
		return "test";
	}
	
}
