package ver1_2;


// BoardDao 같이 단순 sql 실행을 담당하는 클래스
public class KoreaTire implements Tire{
	@Override
	public String getModel() {
		return "한국 타이어";
	}
}
