package ver0_no_aop;

import java.util.Random;

// 회원관리 클래스
public class Boy {
	public void makeFood() {
		System.out.println("배가 고프다."); // 사전에 하고자 하는 작업이 있다면 before

		/////////////////////////////////////////////////////////
		try {
			System.out.println("초밥을 만든다."); // 핵심 관심사항 구현부분
			if (new Random().nextBoolean()) {
				// 핵심 관심사항 실행하다 보면 에러 날 수 있음
				throw new Exception("에러 발생");
			}
			System.out.println("맛있게 먹는다.");
		} catch (Exception e) {
			System.out.println("엄마!!!!!!!!!!!!!!");
		}finally {
			System.out.println("설거지로 마무리");
		}
	}
}
