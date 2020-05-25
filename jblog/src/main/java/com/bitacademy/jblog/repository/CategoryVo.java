package com.bitacademy.jblog.repository;

import java.util.Date;

public class CategoryVo {
	
	private Long cateNo;
	private Long userNo;
	private String cateName;
	private String description;
	private Date regDate;
	public Long getCateNo() {
		return cateNo;
	}
	public Long getUserNo() {
		return userNo;
	}
	public String getCateName() {
		return cateName;
	}
	public String getDescription() {
		return description;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setCateNo(Long cateNo) {
		this.cateNo = cateNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "CategoryVo [cateNo=" + cateNo + ", userNo=" + userNo + ", cateName=" + cateName + ", description="
				+ description + ", regDate=" + regDate + "]";
	}
	
	

}
