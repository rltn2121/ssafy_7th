package com.ssafy.dto;

public class Dong {
	private String code;
	private String name;
	private String city_code;
	private String city_name;
	private String gugun_code;
	private String gugun_name;
	public Dong(String code, String name, String city_code, String city_name, String gugun_code, String gugun_name) {
		super();
		this.code = code;
		this.name = name;
		this.city_code = city_code;
		this.city_name = city_name;
		this.gugun_code = gugun_code;
		this.gugun_name = gugun_name;
	}
	public String getCode() {
		return code;
	}
	@Override
	public String toString() {
		return "Dong [code=" + code + ", name=" + name + ", city_code=" + city_code + ", city_name=" + city_name
				+ ", gugun_code=" + gugun_code + ", gugun_name=" + gugun_name + "]";
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getGugun_code() {
		return gugun_code;
	}
	public void setGugun_code(String gugun_code) {
		this.gugun_code = gugun_code;
	}
	public String getGugun_name() {
		return gugun_name;
	}
	public void setGugun_name(String gugun_name) {
		this.gugun_name = gugun_name;
	}
	
	

	
}
