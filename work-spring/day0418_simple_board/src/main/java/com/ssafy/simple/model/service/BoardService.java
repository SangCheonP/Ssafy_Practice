package com.ssafy.simple.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.simple.model.dao.BoardDAO;
import com.ssafy.simple.model.dto.BoardDTO;

// 추후 글 읽기 등을 수행할 때 작성자 본인은 조회수 증가 못하게 한다던지. 하루에 조회수 1만 늘어나게 한다던지 등등
@Service
public class BoardService {
	
	@Autowired
	private BoardDAO bdao;// = new BoardDAO(); // 너네는 싱글턴 해라
	
	public int write(BoardDTO board) throws SQLException {
		return bdao.insert(board);
	}
	
	// 현재 보고싶은 페이지가 몇페이지 인지 재료로 들어오면 해당 페이지 정보 포함
	// 화면 하단의 시작-끝 페이지랑 총 게시글 갯수를 활용한 총 페이지수 계산. 현재 페이지에 보여질 게시글(최대10개)도 조회.
	public Map<String, Object> makePage(int curPage){
		Map<String, Object> map = new HashMap();
		
		int startPage = (curPage-1)/10*10+1; // 11~20 -> 10~19로 만들고 /10*10하면서 1의자리 떨구고 10+1=11
		int endPage = startPage+9; // 11~20 이니까 일단 계산하는데..
		
		int totalCount = bdao.selectTotalCount(); // 총 게시글이 178개라고 가정하자. dao한테 일시키기
		int totalPage = totalCount/10; // 한페이지당 10개씩 보여줄거라 일단 페이지 총 17페이지까지 라고 계산
		if(totalCount%10 > 0) { // 한페이지당 10개씩 끊었는데 게시글이 남았어?
			totalPage++; // 한페이지 더 필요하네
		}
		
		if(totalPage < endPage) { // 무조건 9페이지 더했더니 실제 필요한 페이지보다 더 많이 계산되어 버렸네;;
			endPage = totalPage; 
		}
		
		int startRow = (curPage-1)*10; // 1page:0, 2page:10, 3page:20, 4page:30, ...
		int count = 10; // 일단 한페이지당 10개
		List<BoardDTO> boardList = bdao.selectList(startRow, count); // dao한테 일시키기
		System.out.println(boardList);
		
		map.put("curPage", curPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
		map.put("boardList", boardList);
		
		return map;
	}
}




