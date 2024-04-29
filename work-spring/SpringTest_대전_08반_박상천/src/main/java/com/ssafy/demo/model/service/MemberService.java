package com.ssafy.demo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.demo.model.dto.MemberDto;
import com.ssafy.demo.model.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	
	public MemberDto login(String id, String pw) {
		return memberMapper.login(id, pw);
	}
	
}
