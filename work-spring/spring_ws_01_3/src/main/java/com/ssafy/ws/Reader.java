package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("person")
public class Reader {
	@Autowired
	@Qualifier("comicBook")
	private Book book;
	
	public void read() {
		System.out.println(book.getInfo());
	}
}
