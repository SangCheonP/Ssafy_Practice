package com.ssafy.simple.model.dto;

public class FileDTO {
	private int fno;
	private String originalName;
	private String savedName;
	private int bno;
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getSavedName() {
		return savedName;
	}
	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	@Override
	public String toString() {
		return "FileDTO [fno=" + fno + ", originalName=" + originalName + ", savedName=" + savedName + ", bno=" + bno
				+ "]";
	}
	
	
}
