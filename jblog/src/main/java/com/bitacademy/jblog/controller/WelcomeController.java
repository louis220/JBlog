package com.bitacademy.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	@RequestMapping("/")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message", "welcome");
		mav.setViewName("welcome");
		return mav;
	}
	
}
