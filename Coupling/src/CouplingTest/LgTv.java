package day02;

public class LgTv implements Tv {
	@Override
	public void powerOn() {
		System.out.println("���� ����");
	}
	@Override
	public void powerOff() {
		System.out.println("���� ����");
	}
	@Override
	public void volumeUp() {
		System.out.println("�Ҹ� +=10");
	}
	@Override
	public void volumeDown() {
		System.out.println("�Ҹ� -=10");
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
