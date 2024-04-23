package com.ssafy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.member.model.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ConfirmInterceptor implements HandlerInterceptor{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
			if (memberDto != null) {
				return true;
			}
		}
		
		// 로그인 페이지로 리다이렉트
		response.sendRedirect(request.getContextPath() + "/user/login");
		return false;
	}
}
