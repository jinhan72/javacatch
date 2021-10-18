package model.message2;

import java.sql.Date;

public class Message2VO {
	private int mnum;
	private String userID;
	private String title;
	private String content;
	private Date wdate;
	
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	
	
	@Override
	public String toString() {
		return "Message2VO [mnum=" + mnum + ", userID=" + userID + ", title=" + title + ", content=" + content
				+ ", wdate=" + wdate + "]";
	}
	
	
}