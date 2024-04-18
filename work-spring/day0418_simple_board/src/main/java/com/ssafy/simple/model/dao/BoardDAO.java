package com.ssafy.simple.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.simple.model.dto.BoardDTO;

@Repository
public class BoardDAO {
	// 글쓰기
	public int insert(BoardDTO board) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = " insert into board_tb(title, writer, write_date, content) "
				+" values(?,?,now(),?) "; // 물음표 1,2,3번까지 채워야 함.
		
		try {
			conn = DBUtil.makeConnection();
			pstmt = conn.prepareStatement(sql); // sql 미리 준비해라!(물음표 자리 뚫려있음 주의)
			pstmt.setString(1, board.getTitle()); // 1번물음표
			pstmt.setString(2, board.getWriter()); // 2번물음표
			pstmt.setString(3, board.getContent()); // 3번물음표
			
			result = pstmt.executeUpdate(); // sql 실행!			
		}finally {
			DBUtil.close(pstmt, conn);
		}
		return result;
	}
	
	// 게시판 목록 관련 필요한 SQL
	// 총 게시글의 갯수(하단 페이지 계산할 때 필요함.)
	public int selectTotalCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs = null;
		String sql = " select count(bno) from board_tb ";
		
		try {
			conn = DBUtil.makeConnection();
			pstmt = conn.prepareStatement(sql); // sql 미리 준비해라!(물음표 자리 뚫려있음 주의)
			
			rs = pstmt.executeQuery();
			rs.next(); // 유효한 데이터로 내려가기(이 쿼리가 무조건 숫자 하나는 나옴)
			result = rs.getInt(1);
		}catch(Exception ex) {
			System.out.println("BoardDAO selectTotalCount 에서 에러남!");
			ex.printStackTrace(); // 이거 없으면 디버깅 아찔함..
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	
	// 한 페이지에 보여질 게시글(한페이지 최대10개) 꺼내오기
	public List<BoardDTO> selectList(int startRow, int count){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<BoardDTO> result = new ArrayList();
		ResultSet rs = null;
		String sql = " select bno, title, writer, write_date, read_count \r\n"
				+ " from board_tb order by bno desc\r\n"
				+ " limit ?, ? ";
		
		try {
			conn = DBUtil.makeConnection();
			pstmt = conn.prepareStatement(sql); // sql 미리 준비해라!(물음표 자리 뚫려있음 주의)
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBno(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setWriteDate(rs.getString(4));
				board.setReadCount(rs.getInt(5));
				result.add(board);
			}
			
		}catch(Exception ex) {
			System.out.println("BoardDAO selectList 에서 에러남!");
			ex.printStackTrace(); // 이거 없으면 디버깅 아찔함..
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}
}











