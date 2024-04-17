package ver3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


// 나중에 톰캣이나 Controller에서 처리할 동작이라 굳이 달달 외울 필요 없는 부분
public class Driver {
	public static void main(String[] args) {
		
		// 스프링 인터페이스 : 
		// 스프링에서 객체 창고역할을 해주는 클래스
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("ver2/beans.xml");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		Car mycar = (Car) ctx.getBean("sonata");
		Car mycar2 = ctx.getBean(Car.class);
		
		mycar.drive();
		mycar2.drive();
	}
}
