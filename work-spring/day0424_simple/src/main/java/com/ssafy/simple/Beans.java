package com.ssafy.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ssafy.simple.model.dao")
public class Beans { // 스프링 객체 관리를 xml 말고 자바로 하겠다! 라는 강한 의지
	
//	@Bean // <bean>
//	public Car sonata() {
//		Car mycar = new Car();
//		mycar.setTire(kkk()); // <property>
//		return mycar;
//	}
//	
//	@Bean
//	public Tire kkk() {
//		return new KoreaTire();
//	}
}
