package test;

public class IPhone implements Phone {
	private AppleWatch	aw; // ����Ҷ����� new�� ����ؾ��ϴµ� �װ� ��� ��
	private int num;
	

	public void setAw(AppleWatch aw) {
		this.aw = aw;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public IPhone() {
		System.out.println("������ �⺻ ������ ȣ��");
	}
	
	public IPhone(AppleWatch aw, int num) {
		this.aw = aw;
		this.num = num;
		System.out.println("������ ������ ȣ��");
	}
	@Override
	public void power() {
		System.out.println("������ ����"+ this.num);
	}

	@Override
	public void soundUp() {
		aw.soundUp();
		//System.out.println("������ �Ҹ�++");
	}

	@Override
	public void soundDown() {
		aw.soundDown();
		//System.out.println("������ �Ҹ�--");
	}

}
