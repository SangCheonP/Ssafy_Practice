package com.ssafy.simple.model.dto;

public class MemberDTO {
	private String userId;
	private String userPw;
	private String userName;
///////////////////////////////////////////////////////////	
	public MemberDTO() {}

	public MemberDTO(String userId, String userPw, String userName) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}
	
	public MemberDTO(String userId, String userName) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}
/////////////////////////////////////////////////////////////

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "MemberDTO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + "]";
	}
	
}
