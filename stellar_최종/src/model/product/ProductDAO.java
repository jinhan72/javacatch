package model.product;

import java.util.ArrayList;

public class ProductDAO {
	ArrayList<ProductVO> datas;
	public ProductDAO(){
		datas=new ArrayList<ProductVO>();
		datas.add(new ProductVO("�Ƹ޸�ī��",2000));
		datas.add(new ProductVO("ī���",2500));
		datas.add(new ProductVO("����Ǫġ��",5000));
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
