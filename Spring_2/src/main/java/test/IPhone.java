package test;

public class IPhone implements Phone {

	public IPhone() {
		System.out.println("������ �⺻������ ȣ���");
	}
	
	@Override
	public void power() {
		System.out.println("������ ����");
	}

	@Override
	public void soundUp() {
		System.out.println("������ �Ҹ�++");
	}

	@Override
	public void soundDown() {
		System.out.println("������ �Ҹ�--");
	}

}
