package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//전달하려는 방식, 전달하는 경로
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
