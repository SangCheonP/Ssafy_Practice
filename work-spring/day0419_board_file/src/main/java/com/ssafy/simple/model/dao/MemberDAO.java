package com.ssafy.simple.model.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ssafy.simple.model.dto.MemberDTO;

public interface MemberDAO {

	// 로그인 관련
	@Select("select user_id 'userId', user_name 'userName' from member_tb where user_id=#{ii} and user_pw=#{pp}")
	public MemberDTO selectOne(@Param("ii") String id, @Param("pp") String pw);
}
