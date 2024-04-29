package com.ssafy.demo.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.demo.model.dto.LoginHistoryDto;

@Mapper
public interface LoginHistoryMapper {

	public void insertHistory(String id);
	
	public void uploadLogOutTime(int no);
	
	public int getLogId(String id);
	
	public List<LoginHistoryDto> getAllLog();
	
	public List<LoginHistoryDto> getLogs(String id);
	
	public void update(int no, String id, String password, String memberName, String email, String mobile);
}
