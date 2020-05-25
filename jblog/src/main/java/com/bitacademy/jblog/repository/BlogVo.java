package com.bitacademy.jblog.repository;

public class BlogVo {
	private Long userNo;
	private String blogTitle;
	private String logoFile;
	public Long getUserNo() {
		return userNo;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public String getLogoFile() {
		return logoFile;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}
	@Override
	public String toString() {
		return "BlogVo [userNo=" + userNo + ", blogTitle=" + blogTitle + ", logoFile=" + logoFile + "]";
	}
	
	

}
