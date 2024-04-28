package com.ssafy.demo.model.dto;


public class UserDto {
	private String userId;
	private String userPw;
	private String userName;
	
	public UserDto() {}
	
	public UserDto(String userId, String userPw, String userName) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}

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
		return "userDto [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + "]";
	}

	
}
