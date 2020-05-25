package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.PostDao;
import com.bitacademy.jblog.repository.PostVo;
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDao postDaoImpl; 
	
	@Override
	public boolean writePost(PostVo vo) {
		int insertedCount = postDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

}
