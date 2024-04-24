package com.ssafy.simple.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// aop에서 공통처리 클래스
// 적용 대상이 controller인 애들 찾아서 적용
@ControllerAdvice
public class MyExceptionHandler {
	
	// after throwing
	@ExceptionHandler(Exception.class)
	public ModelAndView error() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "에러 발생");
		mav.setViewName("Alert");
		return mav;
	}
}
