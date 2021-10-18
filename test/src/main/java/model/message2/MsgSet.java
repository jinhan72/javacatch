package model.message2;

public class MsgSet {
	private Message2VO m; // 게시글 1개 

	public Message2VO getM() {
		return m;
	}
	public void setM(Message2VO m) {
		this.m = m;
	}
	@Override
	public String toString() {
		return "MsgSet [m=" + m + "]";
	}
	
}
