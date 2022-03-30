package com.ssafy.dto;

public class UserDto {
	
	private String Member_id;
	private String Member_pwd;
	private String Member_nm;
	private String Member_add;
	private String Member_tell;
	
	
	public UserDto(String member_id, String member_pwd, String member_nm, String member_add, String member_tell) {
		super();
		Member_id = member_id;
		Member_pwd = member_pwd;
		Member_nm = member_nm;
		Member_add = member_add;
		Member_tell = member_tell;
	}
	
	public String getMember_id() {
		return Member_id;
	}
	public void setMember_id(String member_id) {
		Member_id = member_id;
	}
	public String getMember_pwd() {
		return Member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		Member_pwd = member_pwd;
	}
	public String getMember_nm() {
		return Member_nm;
	}
	public void setMember_nm(String member_nm) {
		Member_nm = member_nm;
	}
	public String getMember_add() {
		return Member_add;
	}
	public void setMember_add(String member_add) {
		Member_add = member_add;
	}
	public String getMember_tell() {
		return Member_tell;
	}
	public void setMember_tell(String member_tell) {
		Member_tell = member_tell;
	}
	@Override
	public String toString() {
		return "UserDto [Member_id=" + Member_id + ", Member_pwd=" + Member_pwd + ", Member_nm=" + Member_nm
				+ ", Member_add=" + Member_add + ", Member_tell=" + Member_tell + "]";
	}
}
