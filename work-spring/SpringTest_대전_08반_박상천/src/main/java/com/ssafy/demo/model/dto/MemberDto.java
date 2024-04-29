package com.ssafy.demo.model.dto;


public class MemberDto {
	private int no;
	private String member_id;
	private String member_name;
	private String password;
	private String email;
	private String mobile;
	private boolean is_admin;
	
	public MemberDto() {}
	
	public MemberDto(String member_id, String password) {
		super();
		this.member_id = member_id;
		this.password = password;
	}



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isIs_admin() {
		return is_admin;
	}

	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}

	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", member_id=" + member_id + ", member_name=" + member_name + ", password="
				+ password + ", email=" + email + ", mobile=" + mobile + ", is_admin=" + is_admin + "]";
	}
	
	
	
}
