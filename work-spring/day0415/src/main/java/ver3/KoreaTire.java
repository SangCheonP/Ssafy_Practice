package ver3;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// BoardDao 같이 단순 sql 실행을 담당하는 클래스

public class KoreaTire implements Tire{
	@Override
	public String getModel() {
		return "한국 타이어";
	}
}
