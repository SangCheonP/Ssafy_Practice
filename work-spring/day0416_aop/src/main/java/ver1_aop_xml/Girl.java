package ver1_aop_xml;

import java.util.Random;

// 상품 판매 관리 클래스
public class Girl {
	public void makeFood() throws Exception {

		/////////////////////////////////////////////////////////
		System.out.println("김밥을 만든다."); // 핵심 관심사항 구현부분
		if (new Random().nextBoolean()) {
			// 핵심 관심사항 실행하다 보면 에러 날 수 있음
			throw new Exception("에러 발생");
		}
	}
}
