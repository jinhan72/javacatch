package test;

public class GaPhone implements Phone{

	private SmartWatch sw;
	
	public GaPhone() {
		System.out.println("������ �⺻������ ȣ���");
	}
	public GaPhone(SmartWatch sw) {
		this.sw=sw;
		System.out.println("������ ������ ȣ���");
	}
	
	@Override
	public void power() {
		System.out.println("������ ����!");
	}

	@Override
	public void soundUp() {
		sw.soundUp();
		//System.out.println("������ �Ҹ���");
	}

	@Override
	public void soundDown() {
		sw.soundDown();
		//System.out.println("������ �Ҹ��ٿ�");
	}

}
