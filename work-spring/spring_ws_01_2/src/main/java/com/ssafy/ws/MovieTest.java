package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/ssafy/ws/applicationContext.xml");
		
		Movie movie = ctx.getBean("ac", Movie.class);
		
		System.out.println(movie.getInfo());
	}
}
