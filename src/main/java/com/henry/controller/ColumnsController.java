package com.henry.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.henry.entity.Columns;
import com.henry.entity.User;
import com.henry.service.ColumnsService;

@Controller
@RequestMapping("/columns")
public class ColumnsController {
	
	Logger logger = Logger.getLogger(ColumnsController.class);
	
	private ColumnsService columnsService;
	
	@Autowired
	public void setColumnsService(ColumnsService columnsService) {
		this.columnsService = columnsService;
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
	
	//转向到创建专栏的页面
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Columns columns, @ModelAttribute User user) {
		//columnsService.insert(columns);
		return null;
	}
}
