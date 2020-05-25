package com.bitacademy.jblog.repository;


import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.exception.MembersDaoException;



@Repository("membersDao")
public class MembersDaoImpl implements MembersDao {
	@Autowired
	SqlSession sqlsession;
	@Override
	public int insert(MemberVo vo) {
		int insertedCount = 0;
		
		try {
			insertedCount = sqlsession.insert("member.insert", vo); 
		}catch(Exception e) {
	
			e.printStackTrace();
			throw new MembersDaoException("가입중 오류 발생", vo);
		}
		return insertedCount;
	}

	@Override
	public MemberVo selectUser(String id) {
		
		return null;
	}
	
	@Override
	public MemberVo selectUser(String id, String password) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("password", password);
		
		MemberVo member = sqlsession.selectOne("member.selectByIdAndPassword", paramMap);		
		return member;
	}

	@Override
	public int add(BlogVo vo) {
		int insertedCount = sqlsession.insert("newblog.insert", vo);
		return insertedCount;
	}

	@Override
	public Long selectNo() {
		Long userNo = sqlsession.selectOne("member.getPrimaryKey");
		return userNo;
	}

}
