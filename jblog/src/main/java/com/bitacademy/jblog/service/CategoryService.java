package com.bitacademy.jblog.service;

import java.util.List;

import com.bitacademy.jblog.repository.CategoryVo;

public interface CategoryService {
	public List<CategoryVo> getList(Long userNo);
	public boolean write(CategoryVo vo);
	public boolean delete(CategoryVo vo);
	public Long getNo();
}
