package com.bitacademy.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.jblog.repository.BlogVo;
import com.bitacademy.jblog.service.BlogService;

//
//@Controller
//@RequestMapping("/newblog")
//public class NewBlogController {
//	@Autowired
//	BlogService blogServiceImpl;
//	
//
//@RequestMapping(value="/newblog", method=RequestMethod.POST)
//	public String insert(@ModelAttribute BlogVo vo) {
//	boolean isSuccess = blogServiceImpl.newblog(vo);
//	return "redirect:/blogs/blogadmin";
//}

//}






