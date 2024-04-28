package com.ssafy.simple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.simple.model.dto.CommentDTO;
import com.ssafy.simple.model.dto.MemberDTO;
import com.ssafy.simple.model.service.BoardService;

import jakarta.servlet.http.HttpSession;

//@Controller
@RestController // 모든 메소드가 자동으로 @ResponseBody
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private BoardService bservice;
	
	// login된 사용자만 댓글 기능 가능하게 하려면 Interceptor 처리가 여기도 해당되게 설정필요.
	// html 프론트에서 form 태그나 get방식 쿼리스트링 통해 보내는 파라미터는
	// @RequestParam으로 받았었음.
	// 근데, 프론트에서 fetch 비동기 요청으로 보내면서 json객체 데이터를 보내는 경우
	// @RequestBody 애노테이션으로 받아야 함!
	@PostMapping(value="/write", headers={"Content-type=application/json"})
//	@ResponseBody
	public String write( @RequestBody CommentDTO commentDTO, HttpSession session) {
		MemberDTO loginInfo = (MemberDTO) session.getAttribute("loginInfo");
//		String cwriter = loginInfo.getUserId();
		String cwriter = "ssafy"; // 내가 외래키까지 잡아놓고 로그인 처리 하겠다고 해서 ;;; 쏴리 ;;;
		String ccontent = commentDTO.getCcontent(); // 이 부분은 서비스 만들 때 뇌를 비웠더니 좀 이상하게 됐네...ㅠㅠ
		int bno = commentDTO.getBno();
		if(bservice.writeComment(cwriter, ccontent, bno) == 1) { // 댓글 작성 무사히 완료
			return "ok";
		}else {
			return "fail";
		}
	}
	
	@GetMapping("/list/{bbb}") // http://localhost:8080/board/comment/list/166
//	@ResponseBody // ModelAndView 구조가 아니라고 알리기. ViewResolver 한테 뷰 찾으러 안가야 함!
	public List<CommentDTO> list(@PathVariable("bbb") int bno){
		return bservice.getComments(bno); // db에서 꺼낸 댓글 데이터 리스트
	}
}









