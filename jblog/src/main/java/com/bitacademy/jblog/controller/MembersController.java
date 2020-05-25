package com.bitacademy.jblog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.jblog.exception.MembersDaoException;
import com.bitacademy.jblog.repository.BlogVo;
import com.bitacademy.jblog.repository.CategoryVo;
import com.bitacademy.jblog.repository.MemberVo;
import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.service.MembersService;



@Controller
@RequestMapping("/users")
public class MembersController {
	private static final Logger logger = LoggerFactory.getLogger(MembersController.class);
	@Autowired
	MembersService membersService;
	@Autowired
	BlogService blogServiceImpl;
	@Autowired
	CategoryService categoryServiceImpl;
	
	//가입 폼 보여주기
	@RequestMapping(value ="/join", method=RequestMethod.GET)
	public String joinform(@ModelAttribute MemberVo memberVo) { //modelattribute�� �־�� ���డ��..
		return "users/joinform";
	
		
	}
	//가입절차 처리
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinAction(@ModelAttribute @Valid MemberVo vo, BindingResult result, Model model) {
	//@Valid 어노테이션이 붙은 모델을 검증작업 수행
	// 검증결과는 BindingResult로 넘어오게 된다
	logger.debug("MemberVo:" + vo);
	if(result.hasErrors()) {
		//모델 검증 결과 에러가 있을 경우
		List<ObjectError> errors = result.getAllErrors();
		for (ObjectError error: errors) {
			logger.error("Object Error:" + error);
		}
		//BindingResult의 모든 정보를  model에 세팅
		model.addAllAttributes(result.getModel());
		return "users/joinform";
	}
	
	boolean isSuccess = false;
	try {
		
		//	PK 받아오기
		Long userNo = membersService.getNo();
		vo.setUserNo(userNo);
		isSuccess = membersService.join(vo);
		
		
		BlogVo bvo = new BlogVo();
		bvo.setUserNo(userNo);
		bvo.setBlogTitle(vo.getUserName() + "님의 블로그입니다.");
		isSuccess = blogServiceImpl.newblog(bvo);
		
		
		CategoryVo cvo = new CategoryVo();
		cvo.setUserNo(userNo);
		cvo.setCateName("미분류");
		cvo.setDescription("분류되지 않은 게시물");
		isSuccess= categoryServiceImpl.write(cvo);
		
		
	}catch (MembersDaoException e) {
		System.err.println("MembersDao 오류:" + e.getMessage());
		System.err.println("오류 발생 당시의 객체 정보:" + e.getVo());
	}
	if (isSuccess) {
		//가입 선공
		return "redirect:/users/joinsuccess";
	}else {
		//가입 실패
		return "redirect:/users/join";
	}
}
	//가입 성공 페이지
@RequestMapping("/joinsuccess")
public String joinSuccess() {
	return "users/joinsuccess";
	}

	//로그인 폼
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
	return "users/loginform";
}

	// 로그인 기능
	@RequestMapping(value="/login", method=RequestMethod.POST)
		public String loginAction(@RequestParam(value="id", required= false) String id,
								  @RequestParam(value="password", required=false) String password,
								  HttpSession session) {
		
		if(id.length() == 0 || password.length() == 0) {
			System.err.println("로그인할수 없음");
			return "redirect:/users/login";
		}
		MemberVo authMember = membersService.getUser(id, password);
		if(authMember == null) {
			System.err.println("사용자를 찾지 못함");
			return "redirect:/users/login";
		}else {
			// 사용자를 찾음
			//세션에 등록 후 홈페이지로 리다이렉드
			session.setAttribute("authMember", authMember);
			return "redirect:/";
		}
	}

		//로그아웃
		@RequestMapping(value="/logout", method=RequestMethod.GET)
		public String logoutAction(HttpSession session) {
			session.invalidate(); 
			return "redirect:/";
		}
		
}	
		
		