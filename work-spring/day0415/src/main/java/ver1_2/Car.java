package ver1_2;

public class Car {
	private Tire tire;
	private Color color;
	
//	public Car() {
//		
//	}
	
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void drive() {
		System.out.println("현재 주행 정보 : " + tire.getModel());
	}
}
