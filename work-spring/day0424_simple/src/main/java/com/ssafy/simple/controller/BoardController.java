package com.ssafy.simple.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.simple.model.dto.BoardDTO;
import com.ssafy.simple.model.dto.FileDTO;
import com.ssafy.simple.model.dto.MemberDTO;
import com.ssafy.simple.model.service.BoardService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value="/board")
public class BoardController {
	@Autowired
	private BoardService bservice;
	
	@GetMapping("/list")
	public ModelAndView getMethodName(@RequestParam(value="page", defaultValue = "1") int page) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BoardPage");
		mav.addObject("pageInfo", bservice.makePage(page));
		return mav;
	}
	
	@GetMapping("/write")
	public String write() {
		// 만약 인터셉터로 로그인 체크 안한 경우 여기서 session으로 로그인 체크 할 수도 있음.(예전 백엔드에서 그랬음)
		return "BoardWrite";
	}
	
	@PostMapping("/write") // 애노테이션으로 에러화면 보여주는거 해봐라~~~~~~^^^^^^^^^
	public String write(BoardDTO board, 
			@RequestParam("uploadedFiles") MultipartFile[] uploadedFiles, 
			HttpSession session) throws SQLException, IllegalStateException, IOException {
		// 여기는 인터셉터에 의해 무조건 로그인된 사용자만 실행 가능하니까 로그인정보 무조건 있다하고 진행해도 됨.
		MemberDTO loginInfo = (MemberDTO) session.getAttribute("loginInfo");
		board.setWriter(loginInfo.getUserId());
		bservice.write(board, uploadedFiles); // 에러상황에 대한 조치를 여기서 try-catch로 해도 되고 예외처리 애노테이션 써도 됨.
		/////////////////////////////////////////////////////////////////////////
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/read")
	public String read(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", bservice.read(bno));
		return "BoardRead"; // BoardRead.jsp
	}
	
	@GetMapping("/download")
	public void download(@RequestParam ("fno") int fno, HttpServletResponse resp) throws IOException {
		FileDTO fileInfo = bservice.getFileInfo(fno);
		
		// 파일 이름은 이거고(한글때매 인코딩 처리까지 해서 줄게)
		resp.setHeader("Content-Disposition", "attachment; filename=\""+ 
					new String(fileInfo.getOriginalName().getBytes("UTF-8"), "ISO-8859-1")+"\";");
		// 지금 응담 response는 html 화면 아니고 이진 파일이란다^^
		resp.setHeader("Content-Transfer-Encoding", "binary");
		
		File savedFile = new File(fileInfo.getSavedPath()); // 서버한테 저장되어 있는 파일을 읽자
		FileInputStream fis = new FileInputStream(savedFile);
		OutputStream os = resp.getOutputStream();
		FileCopyUtils.copy(fis, os);
	}
	
}










