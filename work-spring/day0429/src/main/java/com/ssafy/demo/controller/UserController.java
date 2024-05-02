package com.ssafy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.demo.model.dto.UserDto;
import com.ssafy.demo.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String userLogin(@RequestParam("userId") String userId,
							@RequestParam("userPw") String userPw,
							Model model,
							HttpSession session) {
		
		UserDto loginInfo = userService.login(userId, userPw); 
		
		System.out.println(loginInfo);
		
		if(loginInfo != null) {
			session.setAttribute("loginInfo", loginInfo);
			return "redirect:/";
		}else {
			model.addAttribute("msg", "로그인에 실패하였습니다. 아이디와 패스워드를 확인하세요.");
			return "Alert"; 
		}
	}
	
}
