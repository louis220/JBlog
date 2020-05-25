package com.bitacademy.jblog.repository;

import java.util.Date;

public class PostVo {
	private Long postNo;
	private Long cateNo;
	private String postTitle;
	private String postContent;
	private Date regDate;
	public Long getPostNo() {
		return postNo;
	}
	public Long getCateNo() {
		return cateNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}
	public void setCateNo(Long cateNo) {
		this.cateNo = cateNo;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "PostVo [postNo=" + postNo + ", cateNo=" + cateNo + ", postTitle=" + postTitle + ", postContent="
				+ postContent + ", regDate=" + regDate + "]";
	}
	

}
