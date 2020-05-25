package com.bitacademy.jblog.service;

import com.bitacademy.jblog.repository.BlogVo;
import com.bitacademy.jblog.repository.MemberVo;

public interface MembersService {
	
	public boolean join(MemberVo vo);
	public MemberVo getUser(String id, String password);
	public MemberVo getUser(String id);
	public Long getNo();
	public boolean newblog(BlogVo vo);

}
