package model.order;

public class OrderVO {
	private String userID;
	private String product;
	private int orderCnt;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	public OrderVO(String userID, String product, int orderCnt) {
		this.userID = userID;
		this.product = product;
		this.orderCnt = orderCnt;
	}
}
