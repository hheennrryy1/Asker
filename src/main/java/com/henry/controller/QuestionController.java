package com.henry.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.henry.entity.Answer;
import com.henry.entity.Question;
import com.henry.entity.QuestionTag;
import com.henry.entity.Tag;
import com.henry.entity.User;
import com.henry.entity.Vote;
import com.henry.entity.VoteKey;
import com.henry.service.AnswerService;
import com.henry.service.QuestionService;
import com.henry.service.QuestionTagService;
import com.henry.service.TagService;
import com.henry.service.VoteService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	Logger logger = Logger.getLogger(QuestionController.class);
	
	public static final int PAGE_SIZE = 2;
	
	private QuestionService quesService;
	private TagService tagService;
	private QuestionTagService questagService;
	private AnswerService answerService;
	private VoteService voteService;
	
	@Autowired
	public void setQuesService(QuestionService quesService) {
		this.quesService = quesService;
	}

	@Autowired
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}

	@Autowired
	public void setQuestagService(QuestionTagService questagService) {
		this.questagService = questagService;
	}
	
	@Autowired
	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}
	
	@Autowired
	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}

	//跳转到提问页面
	@RequestMapping(value = "/ask", method = RequestMethod.GET)
	public String toAsk() {
		return "question/ask";
	}

	@ModelAttribute
	public User getSessionUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}
	
	//提问
	@RequestMapping(value = "/ask", method = RequestMethod.POST)
	public String ask(String tagStr, Question question, @ModelAttribute User user) {
		String []tagsName = tagStr.split(",");
		//存放每个问题的tag
		List<Tag> tags = new ArrayList<>();
		
		//用tag的name找到tag的id
		for(String name : tagsName) {
			Tag tag = tagService.selectByName(name);
			//如果tag不存在，则新增这个tag
			if(tag == null) {
				tag = new Tag(name);
				tagService.insert(tag);
			}
			tags.add(tag);
		}
		
		question.setCreatedTime(new Date());
		question.setUser(user);
		quesService.insert(question);
		
		//存Question和Tag的关系
		QuestionTag qt = new QuestionTag();
		qt.setQuestion(question);
		for(Tag tag : tags) {
			qt.setTag(tag);
			questagService.insert(qt);
		}
		return "index";
	}
	
	//跳到问题页面
	@RequestMapping("/{questionId}")
	public ModelAndView question(ModelAndView mav, @PathVariable("questionId") Integer id, @ModelAttribute User user, 
									@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum) {
		boolean answered = false;//判断该用户是否已经回答了
		
		Question question = quesService.selectById(id);
		//不存在这个问题 抛异常
		if(question == null) {
			throw new NullPointerException();
		}
		mav.addObject("question", question);
		
		//找到问题下的答案，并分页
		PageInfo<Answer> page = answerService.selectByQuestionId(id, pageNum, PAGE_SIZE);
		
		VoteKey key = new VoteKey();
		for(Answer a : page.getList()) {
			key.setAnswer(a);
			key.setUser(user);
			Vote vote = voteService.select(key);
			//没点过
			if(vote == null) {
				//Do nothing
			} else {
				a.setLiked(vote.getMode());
			}
		}
		
		mav.addObject("page", page);
		//检测用户是否已经回答过问题
		List<Answer> answers = answerService.selectByQidAndUid(id, user.getId());
		if(!answers.isEmpty()) { //不空的
			answered = true;
		}
		mav.addObject("answered", answered);
		mav.setViewName("question/question");
		return mav;
	}
}