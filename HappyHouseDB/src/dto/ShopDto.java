package dto;

public class ShopDto {
	private int shopNo;
	private String shopName;
	private String dongCode;
	private String dongName;
	private String rodeAddress;
	private String lat;
	private String lng;
	public ShopDto(int shopNo, String shopName, String dongCode, String dongName, String rodeAddress, String lat,
			String lng) {
		super();
		this.shopNo = shopNo;
		this.shopName = shopName;
		this.dongCode = dongCode;
		this.dongName = dongName;
		this.rodeAddress = rodeAddress;
		this.lat = lat;
		this.lng = lng;
	}
	public ShopDto() {
		super();
	}
	public int getShopNo() {
		return shopNo;
	}
	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	public String getRodeAddress() {
		return rodeAddress;
	}
	public void setRodeAddress(String rodeAddress) {
		this.rodeAddress = rodeAddress;
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
	@Override
	public String toString() {
		return "ShopDto [shopNo=" + shopNo + ", shopName=" + shopName + ", dongCode=" + dongCode + ", dongName="
				+ dongName + ", rodeAddress=" + rodeAddress + ", lat=" + lat + ", lng=" + lng + "]";
	}
	
	
}
