package com.bitacademy.jblog.exception;

import com.bitacademy.jblog.repository.MemberVo;

public class MembersDaoException extends RuntimeException{
	
	private MemberVo vo =null;
	
	public MembersDaoException() {
		super();
	}
	public MembersDaoException(String message) {
		super(message);
	}
	
	public MembersDaoException(String message, MemberVo vo) {
		super(message);
		this.vo =vo;
	}
	public MemberVo getVo() {
		return vo;
	}

	public void setVo(MemberVo vo) {
		this.vo = vo;
	}

	@Override
	public String toString() {
		return "MemberDaoException [vo=" + vo + "]";
	}
	
}
