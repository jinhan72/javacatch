package day02;

public class LgTv implements Tv {
	@Override
	public void powerOn() {
		System.out.println("전원 켜짐");
	}
	@Override
	public void powerOff() {
		System.out.println("전원 꺼짐");
	}
	@Override
	public void volumeUp() {
		System.out.println("소리 +=10");
	}
	@Override
	public void volumeDown() {
		System.out.println("소리 -=10");
	}
	@Override
	public void channelUp() {
		System.out.println("채널+1");
	}
	@Override
	public void channelDown() {
		System.out.println("채널-1");
		
	}
}
