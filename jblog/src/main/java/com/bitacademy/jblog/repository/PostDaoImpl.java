package com.bitacademy.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl implements PostDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(PostVo vo) {
		int insertedCount = sqlSession.insert("post.insert", vo);
		return insertedCount;
	}

}
