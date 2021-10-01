package controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// public abstract 생략 가능 -> 컴파일에서 자동 생성
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;
	// 파라미터로 response, request를 받아 page를 리턴
	// 페이지 경로(path)와 페이지 전달방식(redirect)이 필요하므로 두 값을 필드로 갖는 ActionForward 클래스를 만들어 리턴!
}