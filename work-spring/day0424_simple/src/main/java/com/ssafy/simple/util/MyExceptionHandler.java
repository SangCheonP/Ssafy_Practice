package com.ssafy.simple.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // aop에서 공통처리 클래스인데 적용 대상이 controller인 애들 찾아서 자동 적용
public class MyExceptionHandler {
	// after throwing 인거임.
	@ExceptionHandler(Exception.class)
	public ModelAndView error() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "에러 났대요~~~");
		mav.setViewName("Alert");
		return mav;
	}
}
