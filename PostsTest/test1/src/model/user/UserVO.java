package model.user;

import java.util.Date;

public class UserVO {
	private String uid;
	private String name;
	private String passwd;
	private Date date;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", name=" + name + ", passwd=" + passwd + ", date=" + date + "]";
	}
}
