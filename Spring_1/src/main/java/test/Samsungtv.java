package test;

public class Samsungtv implements Tv {
	
	@Override
	public void powerOn() {
		System.out.println("�층~");
	}

	@Override
	public void PowerOff() {
		System.out.println("�Ѷ�\\");
	}

	@Override
	public void soundUp() {
		System.out.println("�Ҹ�+1");
	}

	@Override
	public void soundDown() {
		System.out.println("�Ҹ�-1");
		
	}

	@Override
	public void chUp() {
		System.out.println("ä��+1");
		
	}

	@Override
	public void chDown() {
		System.out.println("ä��-1");
	}
}
