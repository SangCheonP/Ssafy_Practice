package com.ssafy.simple.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ssafy.simple.model.dto.MemberDTO;

@Mapper
public interface MemberDAO {
	// 로그인 관련
	@Select(" select user_id as 'userId' , user_name as 'userName' from member_tb where user_id=#{ii} and user_pw=#{pp} ")
	public MemberDTO selectOne(@Param("ii") String id, @Param("pp") String pw);
}
