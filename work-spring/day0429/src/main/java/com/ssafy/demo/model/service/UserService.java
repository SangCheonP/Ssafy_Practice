package com.ssafy.demo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.demo.model.dto.UserDto;
import com.ssafy.demo.model.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	public UserDto login(String id, String pw) {
		return userMapper.login(id, pw);
	}
	
}
