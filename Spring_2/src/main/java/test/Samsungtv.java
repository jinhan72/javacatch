package test;

public class Samsungtv implements Tv {
	
	private PlayStation5 ps;
	public Samsungtv() {
		System.out.println("삼성티비 기본생성자");
	}
	
	public Samsungtv(PlayStation5 ps) {
		this.ps=ps;
		System.out.println("삼성티미 생성자 호출!");
	}

	@Override
	public void powerOn() {
		System.out.println("띠링");
		ps.playgame();
	}
	
	@Override
	public void PowerOff() {
		System.out.println("뚜뚱\\");
		ps.gameover();
	}

	@Override
	public void soundUp() {
		System.out.println("소리+1");
	}

	@Override
	public void soundDown() {
		System.out.println("소리-1");
		
	}

	@Override
	public void chUp() {
		System.out.println("채널+1");
		
	}

	@Override
	public void chDown() {
		System.out.println("채널-1");
	}

}
