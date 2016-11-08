package com.henry.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.henry.entity.Columns;
import com.henry.entity.User;
import com.henry.service.ColumnsService;
import com.henry.service.TagService;

@Controller
@RequestMapping("/columns")
public class ColumnsController {
	
	Logger logger = Logger.getLogger(ColumnsController.class);
	
	private ColumnsService columnsService;
	private TagService tagService;
	
	@Autowired
	public void setColumnsService(ColumnsService columnsService) {
		this.columnsService = columnsService;
	}
	
	@Autowired
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}

	@ModelAttribute
	public User getUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}

	//转向到创建专栏的页面
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String toCreate() {
		return "columns/create";
	}
	
	//创建专栏
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(String tagStr, Columns columns, @ModelAttribute User user) {
		columns.setUser(user);
		columnsService.insert(columns);
		return null;
	}
	
	//转向到具体的专栏的页面
	@RequestMapping("/{cid}")
	public ModelAndView columns(ModelAndView mav, @PathVariable("cid") Integer id, @ModelAttribute User user) {
		Columns columns = columnsService.selectById(id);
		boolean isMyself = false;
		//判断是不是本人进入该专栏
		if(columns.getUser().getId().equals(user.getId())) {
			isMyself = true;
		}
		mav.addObject("columns", columns);
		mav.addObject("isMyself", isMyself);
		mav.setViewName("columns/columns");
		return mav;
	}
	
	@RequestMapping(value = "/{cid}/update", method = RequestMethod.GET)
	public ModelAndView toUpdate(ModelAndView mav, @PathVariable("cid") Integer id, @ModelAttribute User user) {
		Columns columns = columnsService.selectById(id);
		
		//判断是不是本人进入专栏设置页面，不是的话没反应
		if(!columns.getUser().getId().equals(user.getId())) {
			return null;
		}
		mav.addObject("columns", columns);
		mav.setViewName("columns/update");
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Columns columns) {
		columnsService.updateByIdSelective(columns);
		return "redirect:/columns/" + columns.getId();
	}
}