package model.product;

public class ProductVO {
	private String product;
	private int price;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ProductVO(String product, int price) {
		this.product = product;
		this.price = price;
	}
}
