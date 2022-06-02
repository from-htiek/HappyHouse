package com.ssafy.happyhouse.dto;

public class AreaLikeDto {
	private int no;
	private String memId;
	private String sidoName;
	private String gugunName;
	private String dongName;
	private String dongCode;
	
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
	
	public String getSidoName() {
		return sidoName;
	}
	
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	
	public String getGugunName() {
		return gugunName;
	}
	
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	public String getDongName() {
		return dongName;
	}
	
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	
	public String getDongCode() {
		return dongCode;
	}
	
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	
	@Override
	public String toString() {
		return "AreaLikeDto [no=" + no + ", memId=" + memId + ", sidoName=" + sidoName + ", gugunName=" + gugunName
				+ ", dongName=" + dongName + ", dongCode=" + dongCode + "]";
	}
	
}
