package com.ssafy.happyhouse.model;
public class BoardDto {
	private int postNo;
	private String memId;
	private String title;
	private String content;
	private String regDate;
	
	public int getPostNo() {
		return postNo;
	}
	
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	
	public String getMemId() {
		return memId;
	}
	
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	
	@Override
	public String toString() {
		return "BoardDto [postNo=" + postNo + ", memId=" + memId + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}


}
