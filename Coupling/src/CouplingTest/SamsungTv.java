package day02;

public class SamsungTv implements Tv{
	public void volumeUp() {
		System.out.println("�Ҹ�++");
	}
	public void volumeDown() {
		System.out.println("�Ҹ�--");
	}
	public void powerOn() {
		System.out.println("���� ON");
	}
	public void powerOff() {
		System.out.println("���� OFF");
	}
	@Override
	public void channelUp() {
		System.out.println("ä��+1");
	}
	@Override
	public void channelDown() {
		System.out.println("ä��-1");
		
	}
}
