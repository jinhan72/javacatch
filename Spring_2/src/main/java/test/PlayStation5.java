package test;

public class PlayStation5 implements PlayStation{
	public PlayStation5() {
		System.out.println("플스 기본생성자 호출입니다");
	}
	@Override
	public void playgame() {
		System.out.println("뚜둥! 환영합니다");
	}

	@Override
	public void soundUp() {
		System.out.println("소리 소리 소리 +++");
	}

	@Override
	public void soundDown() {
		System.out.println("소리 소리 소리 ---");
	}
	@Override
	public void gameover() {
		System.out.println("빠바바람~ 로그아웃 중~");
	}

}
