package model.msg;

import java.util.ArrayList;

// �Խù��� �� �Խù��� ���� ����� ���� ���������� ���
public class MsgSet {
	private MessageVO m; //
	private ArrayList<ReplyVO> rlist=new ArrayList<ReplyVO>(); // ���÷��� VO�� �ִ� �ֵ��� �����ϴ� rlist�� ����
	public MessageVO getM() {
		return m;
	}
	public void setM(MessageVO m) {
		this.m = m;
	}
	public ArrayList<ReplyVO> getRlist() {
		return rlist;
	}
	public void setRlist(ArrayList<ReplyVO> rlist) {
		this.rlist = rlist;
	}
	@Override
	public String toString() {
		return "MsgSet [m=" + m + ", rlist=" + rlist + "]";
	}
}
