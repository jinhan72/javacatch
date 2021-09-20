package model.msg;

import java.util.Date;

public class MessageVO {
	private int mid;
	private String uid;
	private String msg;
	private int favcount;
	private int replycount;
	private Date date;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getFavcount() {
		return favcount;
	}
	public void setFavcount(int favcount) {
		this.favcount = favcount;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MessageVO [mid=" + mid + ", uid=" + uid + ", msg=" + msg + ", favcount=" + favcount + ", replycount="
				+ replycount + ", date=" + date + "]";
	}
}
