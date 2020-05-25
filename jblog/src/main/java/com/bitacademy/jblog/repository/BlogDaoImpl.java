package com.bitacademy.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BlogDaoImpl implements BlogDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(BlogVo vo) {
		int insertedCount = sqlSession.insert("newblog.insert", vo);
		return insertedCount;
	}

}
