package com.ssafy.book.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.book.model.dto.BookDTO;

//Database Access Object
@Repository
public class BookDAO {	
	public int insert(BookDTO book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " insert into "
				+ " book_tb(title,writer,price) values(?,?,?) ";
		int result = 0; // insert,update,delete를 수행한 결과는 정수로 반환됨.
		
		try {
			conn = DBUtil.makeConnection();
			pstmt = conn.prepareStatement(sql); // 일단 sql을 담긴 했는데 아직 ?들이 채워지지 않음.
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setInt(3, book.getPrice()); // 물음표 자리 다 채움!
			
			// insert,update,delete : executeUpdate();
			result = pstmt.executeUpdate(); // 잦은 실수~!!! pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("insert 수행중 오류남");
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return result;
	}
//	
//	public int update(BookDTO book) {
//		
//	}
//	
//	public int delete(int isbn) {
//		
//	}
//	
//	public BookDTO selectOne(int isbn) {
//		
//	}
	
	public List<BookDTO> selectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookDTO> bookList = new ArrayList<>();
		
		try {
		// 1. 커넥션 생성
			conn = DBUtil.makeConnection();
		// 2. 실행할 SQL 작성
			String sql = "select isbn, title, writer, price from book_tb";
		// 3. Statement or PreparedStatement 수레 생성 및 명령어 탑승
			pstmt = conn.prepareStatement(sql);
		// 4. executeUpdate or executeQuery(SQL 명령어 종류에 따라 둘 중 하나 선택해서 실행)
			rs = pstmt.executeQuery();
		// 5. 결과값 받아서 필요한 처리 완료
			while(rs.next()) { // next를 실행하면 아래로 내려가서 유효한 데이터가 있는지 true/false
				BookDTO book = new BookDTO();
				book.setIsbn(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setWriter(rs.getString("writer")); // 이렇게 컬럼순서 말고 이름으로도 get 가능
				book.setPrice(rs.getInt(4));
				bookList.add(book); //객체에 줍줍 완료한 방금 하나의 행을 리스트에 소중히 담자! 
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			// 6. 사용한 리소스 모두 close
			DBUtil.close(rs, pstmt, conn); // 생성했던 순서 역순으로 넣어줘야 제대로 close 됨.
		}
		return bookList;
	}
}
