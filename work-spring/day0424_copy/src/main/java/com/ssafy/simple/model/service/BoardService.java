package com.ssafy.simple.model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.simple.model.dao.BoardDAO;
import com.ssafy.simple.model.dao.CommentDAO;
import com.ssafy.simple.model.dao.FileDAO;
import com.ssafy.simple.model.dto.BoardDTO;
import com.ssafy.simple.model.dto.CommentDTO;
import com.ssafy.simple.model.dto.FileDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Autowired
	private FileDAO fileDAO;
	
	@Autowired
	private CommentDAO commentDAO;

	public int write(BoardDTO board, MultipartFile[] files) throws SQLException, IllegalStateException, IOException {
		System.out.println("insert 되기 전 bno:" + board.getBno());
		boardDAO.insert(board); // 파일 첨부해서 디비에 기록하려면 지금 작성한 게시글 번호가 필요함.
		System.out.println("insert 되고나서 bno:" + board.getBno());

		String dirPath = "c:/SSAFY/upload";
		File dir = new File(dirPath);
		if (!dir.exists())
			dir.mkdir(); // 업로드할 폴더 없으면 생성함.

		for (MultipartFile file : files) {
			String savedName = new Random().nextInt(100000000) + ""; // 저장되는 이름은 랜덤하게
			File savedFile = new File(dirPath + "/" + savedName); // c:/SSAFY/upload/랜덤이름
			file.transferTo(savedFile); // 실제 서버쪽 폴더에 저장되는 업로드가 일어남.

			FileDTO dto = new FileDTO();
			dto.setOriginalName(file.getOriginalFilename()); // 파일의 원래 이름
			dto.setSavedPath(savedFile.getAbsolutePath()); // 실제 저장된 경로및 랜덤이름
			dto.setBno(board.getBno()); // 어느 게시글에 첨부된 파일인지
			fileDAO.insert(dto);
		}

		return board.getBno();
	}

	// 현재 보고싶은 페이지가 몇페이지 인지 재료로 들어오면 해당 페이지 정보 포함
	// 화면 하단의 시작-끝 페이지랑 총 게시글 갯수를 활용한 총 페이지수 계산. 현재 페이지에 보여질 게시글(최대10개)도 조회.
	public Map<String, Object> makePage(int curPage) {
		Map<String, Object> map = new HashMap();

		int startPage = (curPage - 1) / 10 * 10 + 1; // 11~20 -> 10~19로 만들고 /10*10하면서 1의자리 떨구고 10+1=11
		int endPage = startPage + 9; // 11~20 이니까 일단 계산하는데..

		int totalCount = boardDAO.selectTotalCount(); // 총 게시글이 178개라고 가정하자. dao한테 일시키기
		int totalPage = totalCount / 10; // 한페이지당 10개씩 보여줄거라 일단 페이지 총 17페이지까지 라고 계산
		if (totalCount % 10 > 0) { // 한페이지당 10개씩 끊었는데 게시글이 남았어?
			totalPage++; // 한페이지 더 필요하네
		}

		if (totalPage < endPage) { // 무조건 9페이지 더했더니 실제 필요한 페이지보다 더 많이 계산되어 버렸네;;
			endPage = totalPage;
		}

		int startRow = (curPage - 1) * 10; // 1page:0, 2page:10, 3page:20, 4page:30, ...
		int count = 10; // 일단 한페이지당 10개
		List<BoardDTO> boardList = boardDAO.selectList(startRow, count); // dao한테 일시키기

		map.put("curPage", curPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
		map.put("boardList", boardList);

		return map;
	}

	public BoardDTO read(int bno) {
		BoardDTO board = boardDAO.selectOne(bno); // 게시글 꺼내왔고
		board.setFiles(fileDAO.selectList(bno)); // 그 게시글에 첨부된 파일목록 꺼내서 board 넣고
		return board;
	}

	// 다운로드 요청 들어왔을 때 해당 파일정보 조회
	public FileDTO getFileInfo(int fno) {
		return fileDAO.selectOne(fno);
	}
	
	public int writeComment(String cwriter, String ccontent, int bno) {
		CommentDTO cmt = new CommentDTO();
		cmt.setCwriter(cwriter);
		cmt.setCcontent(ccontent);
		cmt.setBno(bno);
		return commentDAO.insert(cmt);
	}
	
	public List<CommentDTO> getComments(int bno){
		return commentDAO.selectList(bno);
	}
}
