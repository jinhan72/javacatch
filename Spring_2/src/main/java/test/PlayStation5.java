package test;

public class PlayStation5 implements PlayStation{
	public PlayStation5() {
		System.out.println("�ý� �⺻������ ȣ���Դϴ�");
	}
	@Override
	public void playgame() {
		System.out.println("�ѵ�! ȯ���մϴ�");
	}

	@Override
	public void soundUp() {
		System.out.println("�Ҹ� �Ҹ� �Ҹ� +++");
	}

	@Override
	public void soundDown() {
		System.out.println("�Ҹ� �Ҹ� �Ҹ� ---");
	}
	@Override
	public void gameover() {
		System.out.println("���ٹٶ�~ �α׾ƿ� ��~");
	}

}
