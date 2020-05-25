package com.bitacademy.jblog.service;

import com.bitacademy.jblog.repository.PostVo;

public interface PostService {
	public boolean writePost(PostVo vo);
}
