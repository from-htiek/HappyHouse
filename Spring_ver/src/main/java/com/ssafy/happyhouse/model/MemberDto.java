package com.ssafy.happyhouse.model;


public class MemberDto {
	private String memId;
	private String memPw;
	private String memName;
	private String memEmail;
	private String memTel;
	private String signupDate;

	
	public String getMemId() {
		return memId;
	}
	
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	public String getMemPw() {
		return memPw;
	}
	
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	
	public String getMemName() {
		return memName;
	}
	
	public void setMemName(String memName) {
		this.memName = memName;
	}
	
	public String getMemEmail() {
		return memEmail;
	}
	
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	
	public String getMemTel() {
		return memTel;
	}
	
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	
	public String getSignupDate() {
		return signupDate;
	}
	
	public void setSignupDate(String signupDate) {
		this.signupDate = signupDate;
	}

	@Override
	public String toString() {
		return "MemberDto [memId=" + memId + ", memPw=" + memPw + ", memName=" + memName + ", memEmail=" + memEmail
				+ ", memTel=" + memTel + ", signupDate=" + signupDate + "]";
	}

}