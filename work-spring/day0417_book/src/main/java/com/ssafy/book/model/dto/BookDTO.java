package com.ssafy.book.model.dto;

// 기능을 구현하는게 목적이 아니라 Data Transfer Object임. 데이터를 주고 받을때 쓰는 바구니
public class BookDTO {
	private int isbn;
	private String title;
	private String writer;
	private int price;
	
	public BookDTO() {}
	public BookDTO(int isbn, String title, String writer, int price) {
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.price = price;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookDTO [isbn=" + isbn + ", title=" + title + ", writer=" + writer + ", price=" + price + "]";
	}
	
}
