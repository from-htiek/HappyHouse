package com.ssafy.happyhouse.model;

public class HouseDto {
	
	private String aptNo;
	private int aptCode;
	private String aptName;
	private int buildYear;
	private String dealAmount;
	private int dealYear;
	private int dealMonth;
	private boolean userLiked;
	public String getDealAmount() {
		return dealAmount;
	}


	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}


	public int getDealYear() {
		return dealYear;
	}


	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}


	public int getDealMonth() {
		return dealMonth;
	}


	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}


	private String dongCode;
	private String dongName;
	private String jibun;
	private String lat;
	private String lng;
	private String img;
	
	public int getAptCode() {
		return aptCode;
	}


	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}


	public String getAptName() {
		return aptName;
	}


	public void setAptName(String aptName) {
		this.aptName = aptName;
	}


	public String getDongCode() {
		return dongCode;
	}


	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}


	public String getDongName() {
		return dongName;
	}


	public void setDongName(String dongName) {
		this.dongName = dongName;
	}


	public int getBuildYear() {
		return buildYear;
	}


	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}


	public String getJibun() {
		return jibun;
	}


	public void setJibun(String jibun) {
		this.jibun = jibun;
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


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "HouseDto [aptCode=" + aptCode + ", aptName=" + aptName + ", dongCode=" + dongCode + ", dongName="
				+ dongName + ", buildYear=" + buildYear + ", jibun=" + jibun + ", lat=" + lat + ", lng=" + lng
				+ ", img=" + img + "]";
	}


	public String getAptNo() {
		return aptNo;
	}


	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}


	public boolean isUserLiked() {
		return userLiked;
	}


	public void setUserLiked(boolean userLiked) {
		this.userLiked = userLiked;
	}

}
