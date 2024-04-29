package com.ssafy.demo.model.dto;

import java.security.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

public class LoginHistoryDto {
	private int log_id;
	private String member_id;
	private String login_time;
	private String logout_time; 
	
	public LoginHistoryDto() {
		super();
	}
	public LoginHistoryDto(int log_id, String member_id, String login_time, String logout_time) {
		super();
		this.log_id = log_id;
		this.member_id = member_id;
		this.login_time = login_time;
		this.logout_time = logout_time;
	}
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getLogin_time() {
		return login_time;
	}
	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}
	public String getLogout_time() {
		return logout_time;
	}
	public void setLogout_time(String logout_time) {
		this.logout_time = logout_time;
	}
	@Override
	public String toString() {
		return "LoginHistoryDto [log_id=" + log_id + ", member_id=" + member_id + ", login_time=" + login_time
				+ ", logout_time=" + logout_time + "]";
	}
	
	
}
