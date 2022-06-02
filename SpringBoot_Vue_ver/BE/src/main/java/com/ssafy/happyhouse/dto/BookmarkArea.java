package com.ssafy.happyhouse.dto;

public class BookmarkArea {
	private int no;
	private String memId;
	private String dongcode;
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getMemId() {
		return memId;
	}
	
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	public String getDongcode() {
		return dongcode;
	}
	
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}

	@Override
	public String toString() {
		return "BookmarkArea [no=" + no + ", memId=" + memId + ", dongcode=" + dongcode + "]";
	}

	
}
