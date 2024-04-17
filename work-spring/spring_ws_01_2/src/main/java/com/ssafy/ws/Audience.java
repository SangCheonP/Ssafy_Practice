package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Audience {
	
	private Movie movie;
	
	public Audience(){};
	
	public Audience(Movie movie){
		this.movie = movie;
	};
}
