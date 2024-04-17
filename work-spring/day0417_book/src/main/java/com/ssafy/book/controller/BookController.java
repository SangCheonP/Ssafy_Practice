package com.ssafy.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.book.model.dto.BookDTO;
import com.ssafy.book.model.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/list")
	public ModelAndView getBookList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BookList");
		mav.addObject("bList", bookService.getBooks());
		return mav;
	}
	
	@GetMapping("/add")
	public String addBook() {
		return "BookWrite";
	}
	
	@PostMapping("/add")
	public String addBook(BookDTO bookDto, Model model) {
		if(bookService.add(bookDto)) {
			model.addAttribute("msg", bookDto.getTitle());
		}else {
			model.addAttribute("msg", "책 추가에 실패했습니다. 잠시후 다시 시도......");
		}
		return "BookResult";
	}
}
