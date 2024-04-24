package com.ssafy.simple.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.simple.model.dao.MemberDAO;
import com.ssafy.simple.model.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberDTO login(String id, String pw) {
		return memberDAO.selectOne(id, pw);
	}
}
