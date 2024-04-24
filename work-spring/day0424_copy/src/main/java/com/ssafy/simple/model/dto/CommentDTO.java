package com.ssafy.simple.model.dto;

public class CommentDTO {
	private int cno; // 댓글 고유 pk
	private int bno; // 어느 게시글에 매달린 댓글인지
	private String cwriter; // 댓글 작성자
	private String ccontent; // 댓글 내용
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getCwriter() {
		return cwriter;
	}
	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	@Override
	public String toString() {
		return "CommentDTO [cno=" + cno + ", bno=" + bno + ", cwriter=" + cwriter + ", ccontent=" + ccontent + "]";
	}
}
