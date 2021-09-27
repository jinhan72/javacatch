package day02;

public class BeanFactory {
	public Object getBean(String beanName) {
		if(beanName.equals("Lg")) {
			return new LgTv();
		}
		else if(beanName.equals("Sam")) {
			return new SamsungTv();
		}
		
		return null;
	}
}
