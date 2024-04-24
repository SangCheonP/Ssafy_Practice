package com.ssafy.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.simple.model.dto.MemberDTO;
import com.ssafy.simple.model.service.MemberService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/login")
	public String login(@RequestParam("userId")String userId,
			@RequestParam("userPw")String userPw, Model model, HttpSession session) {
		MemberDTO loginInfo = memberService.login(userId, userPw);
		
		if(loginInfo != null) {
			session.setAttribute("loginInfo", loginInfo);
			return "redirect:/";
		}else {
			model.addAttribute("msg", "로그인에 실패하였습니다. 아이디와 패스워드를 확인하세요.");
			return "Alert";
		}
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("msg", "로그아웃 되었습니다.");
		return "Alert";
	}
	
}
