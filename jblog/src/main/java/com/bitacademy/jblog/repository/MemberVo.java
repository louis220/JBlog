package com.bitacademy.jblog.repository;

import java.util.Date;

public class MemberVo {
	private Long userNo;
	private String id;
	private String userName;
	private String password;
	private Date joindate;
	public Long getUserNo() {
		return userNo;
	}
	public String getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setJoinDate(Date joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "MemberVo [userNo=" + userNo + ", id=" + id + ", userName=" + userName + ", password=" + password
				+ ", joindate=" + joindate + "]";
	}
	
}
