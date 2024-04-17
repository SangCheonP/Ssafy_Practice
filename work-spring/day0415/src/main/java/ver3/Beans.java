package ver3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ver3"})
public class Beans {
	@Bean
	public Tire koreaTire() {
		return new KoreaTire();
	}
	
	@Bean
	public Tire chinaTire() {
		return new ChinaTire();
	}
	
	@Bean
	public Car sonata() {
//		Car car = new Car(); // <bean name="sonata" class="ver3.Car">
//		car.setTire(koreaTire()); // <property>
		Car car = new Car(koreaTire()); // <constructor-arg>
		return car;
	}

}
