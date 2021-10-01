package controller.action;

public class ActionForward {
	
	private boolean redirect; // 페이지 전달 방식
	private String path; // 이동할 페이지 경로
	
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
	
	// redirect - 주로 전달할 데이터가 없을 때 사용 (url쿼리 사용 시 데이터 전달 가능, *.jsp&action=main 형태와 같이)
	// forward - 주로 전달할 데이터가 많을 때 사용
}
