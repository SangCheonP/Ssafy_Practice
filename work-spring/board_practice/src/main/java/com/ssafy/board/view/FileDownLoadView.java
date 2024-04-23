package com.ssafy.board.view;

import java.util.Map;

import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FileDownLoadView extends AbstractView{
	
	// 파일을 다운로드할 때 HTTP 응답의 컨텐츠 타입을 application/download; charset=UTF-8로 명시
	public FileDownLoadView() {
		setContentType("apllication/download; charset=UTF-8");
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
