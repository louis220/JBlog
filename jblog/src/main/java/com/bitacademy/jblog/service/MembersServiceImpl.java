package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.MembersDao;
import com.bitacademy.jblog.repository.BlogVo;
import com.bitacademy.jblog.repository.MemberVo;

@Service("membersService")
public class MembersServiceImpl implements MembersService {
	
	@Autowired
	MembersDao membersDao;
	
	@Override
	public boolean join(MemberVo vo) {
		int insertedCount = membersDao.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public MemberVo getUser(String id, String password) {
		MemberVo vo = membersDao.selectUser(id,password);
		return vo;
	}

	@Override
	public MemberVo getUser(String id) {
		return null;
	}

	@Override
	public boolean newblog(BlogVo vo) {
		int insertedCount = membersDao.add(vo);
		return 1 == insertedCount;
	}

	@Override
	public Long getNo() {
		Long userNo = membersDao.selectNo();
		return userNo;
	}

}
