package com.ssafy.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 객체 관리를 xml말고 자바로 하겠다.
@Configuration
@MapperScan("com.ssafy.simple.model.dao")
public class Beans {

//	@Bean
//	Public Car sonata() {
//		Car mycar = new Car();
//	}
	
}
