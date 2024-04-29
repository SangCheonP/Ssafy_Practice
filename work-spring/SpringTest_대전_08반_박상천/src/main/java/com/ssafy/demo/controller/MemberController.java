package com.ssafy.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.demo.model.dto.LoginHistoryDto;
import com.ssafy.demo.model.dto.MemberDto;
import com.ssafy.demo.model.service.LoginHistoryService;
import com.ssafy.demo.model.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private LoginHistoryService loginHistoryService;
	
	@PostMapping("/login")
	public String userLogin(@RequestParam("memberId") String memberId,
							@RequestParam("password") String password,
							Model model,
							HttpSession session) {
		
		MemberDto loginInfo = memberService.login(memberId, password); 
		
		System.out.println(loginInfo);
		
		if(loginInfo != null) {
			session.setAttribute("loginInfo", loginInfo);
			session.setAttribute("no", loginInfo.getNo());
			session.setAttribute("id", loginInfo.getMember_id());
			session.setAttribute("name",loginInfo.getMember_name());
			session.setAttribute("password", loginInfo.getPassword());
			session.setAttribute("email", loginInfo.getEmail());
			session.setAttribute("mobile", loginInfo.getMobile());
			session.setAttribute("admin", loginInfo.isIs_admin());
			
			// 데이터 베이스에 로그인 시간 기록
			loginHistoryService.insertHistory(memberId);
			
			
			return "redirect:/";
		}else {
			model.addAttribute("msg", "로그인에 실패하였습니다. 아이디와 패스워드를 확인하세요.");
			return "Alert"; 
		}
	}
	
	@GetMapping("/logout")
	public String logout(Model model,HttpSession session) {
		MemberDto member = (MemberDto) session.getAttribute("loginInfo");
		System.out.println(member);
		
		// 로그아웃 시간 추가
		
		int logId = loginHistoryService.getLogId(member.getMember_id()); 
		System.out.println(logId);
		loginHistoryService.uploadLogOutTime(logId);
		
		session.invalidate();
		return "index";
	}
	
	
	@GetMapping("/log")
	public String showLog(Model model,HttpSession session) {
		// 관리자면 모든 로그인 로그 가져오기
		if((boolean)session.getAttribute("admin")) {
				List<LoginHistoryDto> logs = loginHistoryService.getAllLog();
				System.out.println(logs);
				model.addAttribute("logs", logs);
		}else {
				List<LoginHistoryDto> logs = loginHistoryService.getLogs((String)session.getAttribute("id"));
				System.out.println(logs);
				model.addAttribute("logs", logs);
		}
		return "log";
	}
	
	@GetMapping("/view")
	public String showInfo(Model model,HttpSession session) {
		// 관리자면 모든 로그인 로그 가져오기
		model.addAttribute("id", session.getAttribute("no"));
		model.addAttribute("id", session.getAttribute("id"));
		model.addAttribute("password", session.getAttribute("password"));
		if((boolean)session.getAttribute("admin")) {
				model.addAttribute("admin",1);
		}else {
			model.addAttribute("admin",0);
		}
		return "view";
	}
	
	@GetMapping("/modify")
	public String showModify(Model model,HttpSession session) {
		model.addAttribute("id", session.getAttribute("id"));
		model.addAttribute("password", session.getAttribute("password"));
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("email", session.getAttribute("email"));
		model.addAttribute("mobile", session.getAttribute("mobile"));

		return "modify";
	}
	
	@PostMapping("/modify")
	public String updateInfo(@RequestParam("no") int no,
			@RequestParam("id") String id,
			@RequestParam("password") String password,
			@RequestParam("memberName") String memberName,
			@RequestParam("email") String email,
			@RequestParam("mobile") String mobile,
			Model model,HttpSession session) {
		

		loginHistoryService.update(no, id, password, memberName, email, mobile);
		
		return "modify";
	}
}
