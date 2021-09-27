package day02;

public class Person {
	public static void main(String[] args) {
		BeanFactory factory=new BeanFactory();
		Tv tel=(Tv)factory.getBean(args[0]); // lg 0, sam 1
		tel.powerOn();
		tel.volumeDown();
		tel.volumeUp();
		tel.channelUp();
		tel.channelDown();
		tel.powerOff();
	}
}
