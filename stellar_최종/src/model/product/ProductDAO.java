package model.product;

import java.util.ArrayList;

public class ProductDAO {
	ArrayList<ProductVO> datas;
	public ProductDAO(){
		datas=new ArrayList<ProductVO>();
		datas.add(new ProductVO("아메리카노",2000));
		datas.add(new ProductVO("카페라떼",2500));
		datas.add(new ProductVO("프라푸치노",5000));
	}
	public int select(String name) {
		for(ProductVO vo:datas) {
			if(vo.getProduct().equals(name)) {
				return vo.getPrice();
			}
		}
		return 0;
	}
}
