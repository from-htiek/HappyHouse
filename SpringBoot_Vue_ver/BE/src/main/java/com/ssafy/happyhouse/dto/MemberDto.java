package com.ssafy.happyhouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MemberDto (회원정보)", description = "회원의 상세 정보를 나타낸다.")
public class MemberDto {
	
	@ApiModelProperty(value = "회원 아이디")
	private String memId;
	@ApiModelProperty(value = "회원 비밀번호")
	private String memPw;
	@ApiModelProperty(value = "회원 이름")
	private String memName;
	@ApiModelProperty(value = "회원 이메일")
	private String memEmail;
	@ApiModelProperty(value = "회원 전화번호")
	private String memTel;
	@ApiModelProperty(value = "회원 가입일")
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
