package com.ssafy.happyhouse.dto;

public class HouseDetailDto {
	private int aptCode;
	private String aptName;
	private String dongCode;
	private String dongName;
	private String sidoName;
	private String gugunName;
	private int buildYear;
	private String dealAmount;
//	private int dealYear;
//	private int dealMonth;
//	private int dealDay;
	private String dealDate;
	private int area;
	private int floor;
	private String lat;
	private String lng;
	private String img;
	private int houseLikeno;
	
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
	
	public int getBuildYear() {
		return buildYear;
	}
	
	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}
	
	public String getDealAmount() {
		return dealAmount;
	}
	
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	
	public String getDealDate() {
		return dealDate;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}

	public int getArea() {
		return area;
	}
	
	public void setArea(int area) {
		this.area = area;
	}
	
	public int getFloor() {
		return floor;
	}
	
	public void setFloor(int floor) {
		this.floor = floor;
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

	public int getHouseLikeno() {
		return houseLikeno;
	}

	public void setHouseLikeno(int houseLikeno) {
		this.houseLikeno = houseLikeno;
	}

}
