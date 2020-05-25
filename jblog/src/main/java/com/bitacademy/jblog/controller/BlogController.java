package com.bitacademy.jblog.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.jblog.repository.BlogVo;
import com.bitacademy.jblog.repository.CategoryVo;
import com.bitacademy.jblog.repository.MemberVo;
import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.CategoryService;


@Controller
public class BlogController {
	@Autowired
	CategoryService categoryServiceImpl;
	@Autowired
	BlogService blogServiceImpl;
	
	
	@RequestMapping("/{authMember.id}")
	public ModelAndView blog() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Welcome");
		mav.setViewName("blogs/bloghome");
		return mav;
	}
	
	@RequestMapping(value="/{authMember.id}/admin/basic", method=RequestMethod.GET)
	public String blogadmin() {
		
		return "blogs/blogadmin";
	}
	//카테고리
	@RequestMapping(value="/{authMember.id}/admin/category", method=RequestMethod.GET)
	public String list(@ModelAttribute CategoryVo vo, Model model, HttpSession session) {
		MemberVo authMember = (MemberVo)session.getAttribute("authMember");
		List<CategoryVo> list = categoryServiceImpl.getList(authMember.getUserNo());
		model.addAttribute("list", list);
		return "category/list";
	}
	//등록
	@RequestMapping(value="/{authMember.id}/admin/category", method=RequestMethod.POST)
		public String write(@ModelAttribute CategoryVo vo, HttpSession session) {
		
		MemberVo authMember = (MemberVo)session.getAttribute("authMember");
		vo.setUserNo(authMember.getUserNo());

		boolean isSuccess = categoryServiceImpl.write(vo);
		return "redirect:/{authMember.id}/admin/category";
	}
	//삭제
	@RequestMapping(value="/{authMember.id}/admin/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute CategoryVo vo) {
		boolean isSuccess = categoryServiceImpl.delete(vo);
		return "redirect:/{authMember.id}/admin/category";
	}
		
	//글작성
	@RequestMapping(value="/{authMember.id}/admin/write", method=RequestMethod.GET)
	public String post() {
		
		return "post/write";
	}
	
	
	
	
	

}
