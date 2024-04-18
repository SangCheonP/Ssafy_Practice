package com.ssafy.simple.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.simple.model.dto.BoardDTO;
import com.ssafy.simple.model.dto.MemberDTO;
import com.ssafy.simple.model.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("list")
	public ModelAndView getMethodName(@RequestParam(value = "page", defaultValue = "1") int page) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BoardPage");
		mav.addObject("pageInfo", boardService.makePage(page));
		return mav;
	}
	
	@GetMapping("/write")
	public String write() {
		
		return "BoardWrite";
	}
	
	@PostMapping("/write")
	public String write(BoardDTO boardDTO, HttpSession session) throws SQLException {
		MemberDTO loginInfo = (MemberDTO) session.getAttribute("loginInfo");
		boardDTO.setWriter(loginInfo.getUserId());
		boardService.write(boardDTO);
		return "redirect:/board/list";
	}
}
