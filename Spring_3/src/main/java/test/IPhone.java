package test;

public class IPhone implements Phone {
	private AppleWatch	aw; // 사용할때마다 new를 사용해야하는데 그거 대신 씀
	private int num;
	

	public void setAw(AppleWatch aw) {
		this.aw = aw;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public IPhone() {
		System.out.println("아이폰 기본 생성자 호출");
	}
	
	public IPhone(AppleWatch aw, int num) {
		this.aw = aw;
		this.num = num;
		System.out.println("아이폰 생성자 호출");
	}
	@Override
	public void power() {
		System.out.println("아이폰 전원"+ this.num);
	}

	@Override
	public void soundUp() {
		aw.soundUp();
		//System.out.println("아이폰 소리++");
	}

	@Override
	public void soundDown() {
		aw.soundDown();
		//System.out.println("아이폰 소리--");
	}

}
