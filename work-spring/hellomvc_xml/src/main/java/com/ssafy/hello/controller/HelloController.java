package com.ssafy.hello.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.hello.model.HelloDto;

@Controller
public class HelloController {

	public HelloController() {
		System.out.println("HelloController");
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "박상천");
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/parameter")
	public String prameter() {
		return "param/parameter";
	}
	
	@PostMapping("/parameter")
	public ModelAndView prameter(@RequestParam("userName") String userName, @RequestParam("userAge") int userAge, @RequestParam("fruit") String[] fruit) {
		System.out.println(userName + "님의 나이는 " + userAge + "이고, 좋아하는 과일은 " + fruit[0]);
		ModelAndView mav = new ModelAndView();
		mav.addObject("userInfo", userName + "(" + userAge + ")님 안녕하세여");
		mav.addObject("fruits", fruit);
		mav.setViewName("param/result");
		return mav;
	}
	
//	@PostMapping("/paramdto")
//	public ModelAndView parameter(HelloDto helloDto) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("result", helloDto);
//		mav.setViewName("param/result_dto");
//		return mav;
//	}
	
	@PostMapping("/paramdto")
	public String parameter(HelloDto helloDto, Model model) {
		model.addAttribute("result", helloDto);
	
		return "param/result_dto";
	}
}
