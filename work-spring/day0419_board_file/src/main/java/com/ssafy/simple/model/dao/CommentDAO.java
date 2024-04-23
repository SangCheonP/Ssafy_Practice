package com.ssafy.simple.model.dao;

import java.util.List;

import com.ssafy.simple.model.dto.CommentDTO;

public interface CommentDAO {
	int insert(CommentDTO cmt);
	List<CommentDTO> selectList(int bno);
	// 댓글 삭제나 수정은 여러분의 몫으로 남겨둡니다.....^^
}
