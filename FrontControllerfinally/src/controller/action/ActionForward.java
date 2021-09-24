package controller.action;

public class ActionForward {
	private boolean redirect;  // true로 들어가면 주로 정보를 전달할 것이 없다 re다이렉트
								// false는 forward방식 전달할 정보가 많을때
	private String path;
	public boolean isRedirect() { 
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
