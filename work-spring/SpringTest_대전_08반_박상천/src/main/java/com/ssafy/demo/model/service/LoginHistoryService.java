package com.ssafy.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.demo.model.dto.LoginHistoryDto;
import com.ssafy.demo.model.mapper.LoginHistoryMapper;

@Service
public class LoginHistoryService {
	
	@Autowired
	private LoginHistoryMapper loginHistoryMapper;
	
	public void insertHistory(String id) {
		loginHistoryMapper.insertHistory(id);
	}
	
	public void uploadLogOutTime(int no) {
		loginHistoryMapper.uploadLogOutTime(no);
	}
	
	public int getLogId(String id) {
		return loginHistoryMapper.getLogId(id);
	}
	
	
	public List<LoginHistoryDto> getAllLog(){
		return loginHistoryMapper.getAllLog();
	}
	
	public List<LoginHistoryDto> getLogs(String id){
		return loginHistoryMapper.getLogs(id);
	}
	
	public void update(int no, String id, String password, String memberName, String email, String mobile) {
		loginHistoryMapper.update(no, id, password, memberName, email, mobile);
	}
}
