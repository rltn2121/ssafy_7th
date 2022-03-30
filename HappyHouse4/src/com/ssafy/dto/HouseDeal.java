package com.ssafy.dto;

public class HouseDeal {
	private int no;
	private String aptName;
	private String dealAmount;
	private String area;
	public HouseDeal(int no, String aptName, String dealAmount, String area) {
		super();
		this.no = no;
		this.aptName = aptName;
		this.dealAmount = dealAmount;
		this.area = area;
	}
	public HouseDeal() {
		super();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "HouseDeal [no=" + no + ", aptName=" + aptName + ", dealAmount=" + dealAmount + ", area=" + area + "]";
	}
	
	
}
