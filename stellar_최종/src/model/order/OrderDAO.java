package model.order;

import java.util.ArrayList;

import model.product.ProductDAO;

public class OrderDAO {
	public int calc(ArrayList<OrderVO> datas) {
		
		int totalPrice=0;
		
		ProductDAO productDAO=new ProductDAO();
		for(OrderVO vo:datas) {
			int price=vo.getOrderCnt()*productDAO.select(vo.getProduct());
			totalPrice+=price;
		}
		
		return totalPrice;
		
	}
}
