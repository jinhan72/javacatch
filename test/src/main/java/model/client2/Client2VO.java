package model.client2;

public class Client2VO {
	private String userID;
	private String userPW;
	private String name;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Client2VO [userID=" + userID + ", userPW=" + userPW + ", name=" + name + "]";
	}

	
	
}
