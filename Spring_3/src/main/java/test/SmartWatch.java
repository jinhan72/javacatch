package test;

public class SmartWatch implements Watch{

	public SmartWatch() {
		System.out.println("스마트워치 기본생성자 호출됨");
	}
	
	@Override
	public void soundUp() {
		System.out.println("스마트워치로 소리업!");
	}

	@Override
	public void soundDown() {
		System.out.println("스마트워치로 소리다운!");
	}

}
