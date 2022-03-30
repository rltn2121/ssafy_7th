package com.ssafy.dto;

public class Gugun {
	private String code;
	private String name;
	private String sido_code;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public Gugun(String code, String name, String sido_code) {
		super();
		this.code = code;
		this.name = name;
		this.sido_code = sido_code;
	}
	public String getSido_code() {
		return sido_code;
	}
	public void setSido_code(String sido_code) {
		this.sido_code = sido_code;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
