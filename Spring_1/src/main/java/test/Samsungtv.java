package test;

public class Samsungtv implements Tv {
	
	@Override
	public void powerOn() {
		System.out.println("¶ì¸µ~");
	}

	@Override
	public void PowerOff() {
		System.out.println("¶Ñ¶×\\");
	}

	@Override
	public void soundUp() {
		System.out.println("¼Ò¸®+1");
	}

	@Override
	public void soundDown() {
		System.out.println("¼Ò¸®-1");
		
	}

	@Override
	public void chUp() {
		System.out.println("Ã¤³Î+1");
		
	}

	@Override
	public void chDown() {
		System.out.println("Ã¤³Î-1");
	}
}
