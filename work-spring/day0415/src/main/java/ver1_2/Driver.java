package ver1_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


// 나중에 톰캣이나 Controller에서 처리할 동작이라 굳이 달달 외울 필요 없는 부분
public class Driver {
	public static void main(String[] args) {
		
		// 스프링 인터페이스 : 
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ver1_2/beans.xml");
		Car mycar = (Car) ctx.getBean("sonata");
		Car mycar2 = ctx.getBean(Car.class);
		
		mycar.drive();
		mycar2.drive();
	}
}
