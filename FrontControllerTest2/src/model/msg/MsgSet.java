package model.msg;

import java.util.ArrayList;

// 게시물과 그 게시물에 대한 댓글을 묶고 한페이지에 출력
public class MsgSet {
	private MessageVO m; //
	private ArrayList<ReplyVO> rlist=new ArrayList<ReplyVO>(); // 리플레이 VO에 있는 애들을 저장하는 rlist에 저장
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
