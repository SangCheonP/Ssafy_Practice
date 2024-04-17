package ver1_aop_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ver1_aop_xml/beans.xml");
		
		Girl la = ctx.getBean(Girl.class);
		la.makeFood();
		
//		Boy do = (Boy)ctx.getBean("dowon");
		
	}
}
