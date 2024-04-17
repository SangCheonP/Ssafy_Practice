package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/ssafy/ws/applicationContext.xml");
		
		Reader rd = (Reader)ctx.getBean("person");
		
		rd.read();
	}
	
}
