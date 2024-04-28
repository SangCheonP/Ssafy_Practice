package com.ssafy.demo.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.demo.model.dto.UserDto;

@Mapper
public interface UserMapper {
	
	public UserDto login(@Param("id") String id, @Param("pw") String pw);
}
