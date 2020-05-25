package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SqlSession sqlSession; 
	
	@Override
	public List<CategoryVo> selectAll(Long userNo) {
		List<CategoryVo> list = sqlSession.selectList("category.selectAll", userNo);
		return list;
	}

	@Override
	public int insert(CategoryVo vo) {
		System.out.println("CategoryVo:" + vo);
		int insertedCount = sqlSession.insert("category.insert",vo);
		return insertedCount;
	}

	@Override
	public int delete(CategoryVo vo) {
		int deletedCount = sqlSession.delete("category.delete", vo);
		return deletedCount;
	}

	@Override
	public Long selectNo() {
		Long userNo = sqlSession.selectOne("category.getuserNo");
		return userNo;
	}

}
