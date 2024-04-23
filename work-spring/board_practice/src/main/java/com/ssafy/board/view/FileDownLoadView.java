package com.ssafy.board.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.ServletContext;
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
		
		// 서블릿 컨텍스트(ServletContext) 인스턴스 얻어옴
		ServletContext ctx = getServletContext();
		// 웹 애플리케이션 내의 가상 경로("/upload")를 서버의 실제 파일 시스템 경로로 변환
		String realPath = ctx.getRealPath("/upload");
		
		
		// 전송받은 모델(파일 정보)
		Map<String, Object> fileInfo = (Map<String, Object>) model.get("downloadFile");
        
        String saveFolder = (String) fileInfo.get("sfolder");	// 파일 경로
        String originalFile = (String) fileInfo.get("ofile");	// 원본 파일명(화면에 표시될 파일 이름)
        String saveFile = (String) fileInfo.get("sfile");    	// 암호화된 파일명(실제 저장된 파일 이름)
        // 서버에서 파일을 찾기 위해 File 객체를 생성
        File file = new File(realPath + File.separator  + saveFolder, saveFile);
		
        response.setContentType(getContentType());
        response.setContentLength((int) file.length());
        
        // 웹 브라우저가 인터넷 익스플로러(IE) 여부에 따른 처리
        String header = request.getHeader("User-Agent");
        boolean isIE = header.indexOf("MSIE") > -1 || header.indexOf("Trident") > -1;
        String fileName = null;
        // IE는 다르게 처리
        if (isIE) {
        	fileName = URLEncoder.encode(originalFile, "UTF-8").replaceAll("\\+", "%20");
        } else {
            fileName = new String(originalFile.getBytes("UTF-8"), "ISO-8859-1");
        }
        
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        
        // 클라이언트로 데이터를 전송(HTTP 응답)하는데 사용하기 위해 출력 스트림(OutputStream)을 가져옴
        OutputStream out = response.getOutputStream();
        // 파일에서 바이트를 읽기 위해 FileInputStream 객체를 선언
        FileInputStream fis = null;
        
        try {
        	// 파일로부터 데이터를 읽어들임
            fis = new FileInputStream(file);
            
            // fis로부터 읽은 데이터를 out 스트림에 복사
            // 이 과정은 파일의 내용을 클라이언트로 직접 전송
            FileCopyUtils.copy(fis, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try { 
                    fis.close(); 
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        out.flush();
		
	}
}
