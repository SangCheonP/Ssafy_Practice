package com.ssafy.simple.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.simple.model.dto.BoardDTO;

@Mapper
public interface BoardDAO {
	// 글쓰기
	public int insert(BoardDTO board) throws SQLException;
	// 게시판 목록 관련 필요한 SQL
	// 총 게시글의 갯수(하단 페이지 계산할 때 필요함.)
	public int selectTotalCount();
	// 한 페이지에 보여질 게시글(한페이지 최대10개) 꺼내오기
	public List<BoardDTO> selectList(@Param("sr") int startRow,@Param("cc") int count);
	public BoardDTO selectOne(int bno);
}











