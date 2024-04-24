package com.ssafy.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.simple.util.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Autowired
	
	private LoginInterceptor loginInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/board/**").
		excludePathPatterns("/board/list");
	}
}
