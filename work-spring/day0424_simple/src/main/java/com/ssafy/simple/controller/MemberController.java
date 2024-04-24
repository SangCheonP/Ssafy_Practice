package com.ssafy.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.simple.model.dto.MemberDTO;
import com.ssafy.simple.model.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MemberController {
	@Autowired
	private MemberService mservice;
	
	@PostMapping("/login")
	public String login(@RequestParam("userId")String userId,
						@RequestParam("userPw")String userPw, Model model, HttpSession session) {
		MemberDTO loginInfo = mservice.login(userId, userPw);
		if(loginInfo!=null) { // 로그인 성공
			session.setAttribute("loginInfo", loginInfo);
			return "redirect:/"; // 맨 처음 home 컨트롤러의 index 화면으로 보내기
		}else { // 로그인 실패
			model.addAttribute("msg", "로그인에 실패하였습니다. 아이디와 패스워드를 확인하세요.");
			return "Alert"; // /WEB-INF/Alert.jsp
		}		
	}
	
	@GetMapping("/logout")
	public String logout(Model model,HttpSession session) {
		session.invalidate();
		model.addAttribute("msg", "logout 되었습니다.");
		return "Alert"; // /WEB-INF/Alert.jsp
	}
}



