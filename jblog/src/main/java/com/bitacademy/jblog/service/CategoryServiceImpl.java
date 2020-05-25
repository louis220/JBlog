package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.CategoryDao;
import com.bitacademy.jblog.repository.CategoryVo;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDaoImpl;
	@Override
	public List<CategoryVo> getList(Long userNo) {
		List<CategoryVo> list = categoryDaoImpl.selectAll(userNo);
		return list;
	}

	@Override
	public boolean write(CategoryVo vo) {
		int insertedCount = categoryDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public boolean delete(CategoryVo vo) {
		int deletedCount = categoryDaoImpl.delete(vo);
		return 1 == deletedCount;
	}

	@Override
	public Long getNo() {
		Long userNo = categoryDaoImpl.selectNo();
		return userNo;
	}

}
