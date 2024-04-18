package com.ssafy.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.book.model.dto.BookDTO;
import com.ssafy.book.model.service.BookService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/list")
	public String getBookList(Model model) {
		model.addAttribute("bookList", bookService.getBooks());
		return "BookList";
	}
	
	@GetMapping("/add")
	public String getBookAddPage() {
		return "BookAdd";
	}
	
	@PostMapping("/add")
	public String postBookAdd(BookDTO bookDTO, Model model) {
		if(bookService.add(bookDTO)) {
			model.addAttribute("msg", bookDTO.getTitle() + "가 성공적으로 등록되었습니다.");
		}else {
			model.addAttribute("msg", "책 등록에 실패하였습니다. 잠시후 다시 시도해주세요.");
		}
		
		return "BookResult";
	}
	
	@GetMapping("/selectOne")
	public String selectOne(@RequestParam("isbn") String isbn, Model model) {
		BookDTO bookDTO = bookService.selectOne(isbn);
		if(bookDTO == null) {
			System.out.println("BookDto가 비었습니다.");
		}else {
			System.out.println(bookDTO);
		}
		model.addAttribute("book", bookDTO);
		
		return "BookDetail";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("isbn") int isbn, @RequestParam("title") String title,
			@RequestParam("writer") String writer, @RequestParam("price") int price) {
		
		System.out.println("update");
		BookDTO bookDTO = new BookDTO(isbn, title, writer, price);
		System.out.println(bookDTO);
		int cnt = bookService.update(bookDTO);
		if(cnt > 0) {
			System.out.println(cnt + "개 수정하였습니다.");
		}else {
			System.out.println("수정에 실패하였습니다.");
		}
		return "redirect:/book/list";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("isbn") int isbn) {
		System.out.println("delete");
		System.out.println("isbn: " + isbn);
		
		int cnt = bookService.delete(isbn);
		
		if(cnt > 0) {
			System.out.println(cnt + "개 삭제하였습니다.");
		}else {
			System.out.println("삭제에 실패하였습니다.");
		}
		
		return "redirect:/book/list";
	}

	
}
