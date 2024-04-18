package com.ssafy.simple.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ssafy.simple.model.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	// 로그인 관련
	public MemberDTO selectOne(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		MemberDTO result = null;
		ResultSet rs = null;
		String sql = " select user_id, user_name from member_tb "
				+ " where user_id=? and user_pw=? "; // 물음표 1,2번까지 채워야 함.
		
		try {
			conn = DBUtil.makeConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery(); // sql 실행 : 결과집합
			if(rs.next()) { // where 조건 만족해서 결과가 있는지 체크
				result = new MemberDTO();
				result.setUserId(rs.getString(1));
				result.setUserName(rs.getString(2));
			}					
		}catch(Exception ex) {
			System.out.println("MemberDAO selectOne 에서 에러남!");
			ex.printStackTrace(); // 이거 없으면 디버깅 아찔함..
		}finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return result;
	}
}
