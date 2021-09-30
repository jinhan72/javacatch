package test;

public class GaPhone implements Phone{

	private SmartWatch sw;
	
	public GaPhone() {
		System.out.println("갤럭시 기본생성자 호출됨");
	}
	public GaPhone(SmartWatch sw) {
		this.sw=sw;
		System.out.println("갤럭시 생성자 호출됨");
	}
	
	@Override
	public void power() {
		System.out.println("갤럭시 전원!");
	}

	@Override
	public void soundUp() {
		sw.soundUp();
		//System.out.println("갤럭시 소리업");
	}

	@Override
	public void soundDown() {
		sw.soundDown();
		//System.out.println("갤럭시 소리다운");
	}

}
