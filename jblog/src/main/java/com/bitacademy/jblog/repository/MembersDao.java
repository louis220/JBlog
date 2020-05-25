package com.bitacademy.jblog.repository;


public interface MembersDao {
	public int insert(MemberVo vo); //가입 INSERT
	public MemberVo selectUser(String id);//중복검사용 SELECT
	public MemberVo selectUser(String id, String password);// 로그인용 select
	public Long selectNo(); // user값받아오기
	public int add(BlogVo vo);
}
