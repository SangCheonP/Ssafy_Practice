package com.ssafy.simple.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.simple.model.dao.MemberDAO;
import com.ssafy.simple.model.dto.MemberDTO;

// 지금은 Service 하는일이 겁나 없음. 나중에는 등급관리라던지 로그인 시도 횟수 처리라던지 등등...
@Service
public class MemberService {
	
	@Autowired
	private MemberDAO mdao; // 너네는 싱글턴 해라
	
	public MemberDTO login(String id, String pw) {
		return mdao.selectOne(id, pw);
	}
}
