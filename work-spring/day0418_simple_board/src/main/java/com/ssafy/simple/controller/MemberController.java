package com.ssafy.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.simple.model.dto.MemberDTO;
import com.ssafy.simple.model.service.MemberService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/user")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("/login")
	public String postMethodName(@RequestParam("userId") String userId,
								@RequestParam("userPw") String userPw,
								HttpSession session,
								Model model) {
		MemberDTO loginInfo = memberService.login(userId, userPw);
		
		if(loginInfo != null) {
			session.setAttribute("loginInfo", loginInfo);
			return "redirect:/";
		}else {
			model.addAttribute("msg", "로그인 실패");
			return "Alert";
		}
	}
	
	@GetMapping("/logout")
	public String getMethodName(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("msg", "로그아웃 됨");
		return "Alert";
	}
	
	
}
