package com.ssafy.simple.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.simple.model.dto.FileDTO;

@Mapper
public interface FileDAO {
	int insert(FileDTO f);
	List<FileDTO> selectList(int bno); // bno 게시글에 첨부된 파일 여러개 조회
	FileDTO selectOne(int fno);
}
