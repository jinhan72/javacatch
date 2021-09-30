package test2;

import java.util.List;
import java.util.Map;

public class CBean {
	//private List<String> list; // 리스트 사용시 제네릭이 없으면 이론만 설명하는 코드일 가능성 큼
	private Map<String,String> map;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	

}
