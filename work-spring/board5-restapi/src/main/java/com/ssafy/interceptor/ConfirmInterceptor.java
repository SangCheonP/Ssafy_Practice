package com.ssafy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.member.model.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@SuppressWarnings("deprecation")
//public class ConfirmInterceptor extends HandlerInterceptorAdapter {
//spring 5.3 부터는 HandlerInterceptor implements

public class ConfirmInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) {
			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
			if (memberDto != null) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath() + "/user/login");
		return true;
	}

}