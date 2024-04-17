package ver2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// BoardService라고 상상해보면 makePage등의 비즈니스 로직 처리 클래스
// 로직 처리 과정에서 DB sql 실행이 필요할 때 

//@Component("sonata")
@Service("sonata")
public class Car {
	// mysql / oracle 상관없고 나 디비 작업 시킬 객체 줘!
	@Autowired(required = false)
	@Qualifier("chinaTire")
	private Tire tire;
	
	public Car() {
		
	}
	
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void drive() {
		System.out.println("현재 주행 정보 : " + tire.getModel());
	}
}
