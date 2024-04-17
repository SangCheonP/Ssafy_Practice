package ver1_aop_xml;

public class MyAspect {

	public void bbbefore() {
		System.out.println("배가 고프다.");
	}

	public void aaafterReturing() {
		System.out.println("맛있게 먹는다.");
	}

	public void aaafterThrowing() {
		System.out.println("엄마!!!!!!!!!!!!!!");
	}

	public void aaafter() {
		System.out.println("설거지로 마무리");
	}
}
