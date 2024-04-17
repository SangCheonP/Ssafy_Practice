package ver0;

public class Car {
	//private KoreaTire tire = new KoreaTire();
	private ChinaTire tire = new ChinaTire(); 
	
	public void drive() {
		System.out.println("현재 주행 정보 : " + tire.getModel());
	}
}
