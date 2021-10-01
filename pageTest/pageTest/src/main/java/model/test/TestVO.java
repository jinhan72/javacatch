package model.test;

public class TestVO {
	int tpk;
	String content;
	
	public int getTpk() {
		return tpk;
	}
	public void setTpk(int tpk) {
		this.tpk = tpk;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "TestVO [tpk=" + tpk + ", content=" + content + "]";
	}
	
}
