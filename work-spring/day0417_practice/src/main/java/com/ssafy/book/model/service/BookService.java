package com.ssafy.book.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.model.dao.BookDAO;
import com.ssafy.book.model.dto.BookDTO;

// DAO는 말단 신입사원. 시키는 SQL 심부름만 하고 뭔가 판단해야되는 
// 비즈니스 로직은 대리 직급에 있는 Service가 처리함.
@Service
public class BookService {
	
	@Autowired
	private BookDAO dao;
/////////////////////////////////////////////////////////////
	// 뭔가 판단하는 척이라도..... 실상은 신입 굴리고 땡이지만...
	public boolean add(BookDTO book) {
		if(dao.insert(book)>0) {
			return true;
		}
		return false;
	}
	
	public List<BookDTO> getBooks(){
		return dao.selectAll();
	}
	
	public BookDTO selectOne(String isbn) {
		return dao.selectOne(isbn);
	}
	
	public int update(BookDTO bookDTO) {
		return dao.update(bookDTO);
	}
	
	public int delete(int isbn) {
		return dao.delete(isbn);
	}
}








