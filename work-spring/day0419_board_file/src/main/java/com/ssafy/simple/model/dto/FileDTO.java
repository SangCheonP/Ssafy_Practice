package com.ssafy.simple.model.dto;

public class FileDTO {
	private int fno;
	private String originalName;
	private String savedPath;
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
	public String getSavedPath() {
		return savedPath;
	}
	public void setSavedPath(String savedPath) {
		this.savedPath = savedPath;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	@Override
	public String toString() {
		return "FileDTO [fno=" + fno + ", originalName=" + originalName + ", savedPath=" + savedPath + ", bno=" + bno
				+ "]";
	}
}
