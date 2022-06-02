package com.ssafy.happyhouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "HouseLikeDto (관심매물 정보)", description = "좋아요한 매물의 상세 정보를 나타낸다.")
public class HouseLikeDto {
	@ApiModelProperty(value = "관심매물 번호")
	private int no;
	@ApiModelProperty(value = "관심매물 좋아요한 회원의 아이디")
	private String memId;
	@ApiModelProperty(value = "관심매물 아파트코드")
	private int aptCode;
	@ApiModelProperty(value = "관심매물 등록 날짜")
	private String addDate;
	
	@ApiModelProperty(value = "관심매물 아파트 이름")
	private String aptName;
	@ApiModelProperty(value = "관심매물 위도")
	private String lat;
	@ApiModelProperty(value = "관심매물 경도")
	private String lng;
	
	
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
	public int getAptCode() {
		return aptCode;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	
	@Override
	public String toString() {
		return "HouseLikeDto [no=" + no + ", memId=" + memId + ", aptCode=" + aptCode + ", addDate=" + addDate
				+ ", aptName=" + aptName + ", lat=" + lat + ", lng=" + lng + "]";
	}
	
}
