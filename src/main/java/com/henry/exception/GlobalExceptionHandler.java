package com.henry.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	public static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ModelAndView handlerNullPointer(Exception e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exception/nullPointerException");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handlerException(Exception e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView();
		//mav.addObject("info", "服务器出现错误");
		mav.addObject("info", e.getMessage());
		if(e instanceof MaxUploadSizeExceededException) {
			mav.addObject("info", "文件太大，请重试!");
		}
		mav.setViewName("exception/exception");
		return mav;
	}
}
