package com.ssafy.happyhouse.model.dto;

public class StoreInfo {
	/**상호명*/	
	private String storeNm;
	/**상권업종대분류명*/	
	private String sectorNm1;
	/**법정동명*/	
	private String dongNm;
	/**도로명주소*/	
	private String address;

	/** Constructor */
	public StoreInfo() {}
	
	/** Getter & Setter */
	public String getStoreNm() {
		return storeNm;
	}
	public void setStoreNm(String storeNm) {
		this.storeNm = storeNm;
	}
	public String getSectorNm1() {
		return sectorNm1;
	}
	public void setSectorNm1(String sectorNm1) {
		this.sectorNm1 = sectorNm1;
	}
	public String getDongNm() {
		return dongNm;
	}
	public void setDongNm(String dongNm) {
		this.dongNm = dongNm;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	/** toString() */
	@Override
	public String toString() {
		String ret = String.format("%-40s\t| %-10s\t| %s", storeNm, sectorNm1, address);
		return ret;
	}
}
