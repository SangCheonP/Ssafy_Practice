package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class Magazine implements Book{
	@Override
	public String getInfo() {
		return "잡지!";
	}
}
