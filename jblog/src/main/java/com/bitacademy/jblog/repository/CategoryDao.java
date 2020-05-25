package com.bitacademy.jblog.repository;

import java.util.List;

public interface CategoryDao {
	public List<CategoryVo> selectAll(Long userNo);
	public int insert(CategoryVo vo);
	public int delete(CategoryVo vo);
	public Long selectNo();
	
}
