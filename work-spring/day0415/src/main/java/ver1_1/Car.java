package ver1_1;

public class Car {
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
