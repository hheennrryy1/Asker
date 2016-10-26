package com.henry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/columns")
public class ColumnsController {
	
	//转向到创建专栏的页面
	@RequestMapping("/create")
	public String create() {
		return "columns/create";
	}
	
	
}
