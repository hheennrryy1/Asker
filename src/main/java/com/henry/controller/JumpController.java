package com.henry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
	
	@RequestMapping("/index")
	public String toIndex() {
		return "index";
	}
}
