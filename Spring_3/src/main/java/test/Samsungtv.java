package test;

public class Samsungtv implements Tv {
	
	private PlayStation5 ps;
	public Samsungtv() {
		System.out.println("�ＺƼ�� �⺻������");
	}
	
	public Samsungtv(PlayStation5 ps) {
		this.ps=ps;
		System.out.println("�ＺƼ�� ������ ȣ��!");
	}

	@Override
	public void powerOn() {
		System.out.println("�층");
		ps.playgame();
	}
	
	@Override
	public void PowerOff() {
		System.out.println("�Ѷ�\\");
		ps.gameover();
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
