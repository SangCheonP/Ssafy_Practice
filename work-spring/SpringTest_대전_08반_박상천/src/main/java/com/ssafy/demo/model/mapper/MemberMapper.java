package com.ssafy.demo.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.demo.model.dto.MemberDto;

@Mapper
public interface MemberMapper {
	
	public MemberDto login(@Param("id") String id, @Param("pw") String pw);
}
