package day02;

public class SamsungTv implements Tv{
	public void volumeUp() {
		System.out.println("소리++");
	}
	public void volumeDown() {
		System.out.println("소리--");
	}
	public void powerOn() {
		System.out.println("전원 ON");
	}
	public void powerOff() {
		System.out.println("전원 OFF");
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
