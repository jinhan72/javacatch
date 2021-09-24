package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.UserDAO;
import model.user.UserVO;

public class SignupAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		UserDAO uDAO = new UserDAO();
		UserVO uVO = new UserVO();
		uVO.setUid(request.getParameter("uid"));
		uVO.setPasswd(request.getParameter("passwd"));
		uVO.setName(request.getParameter("name"));
	
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(uDAO.insert(uVO)) {
			out.println("<script>alert('회원가입 완료! 로그인후에 이용하세요! :D');window.close();</script>");
		}
		else {
			out.println("<script>alert('회원가입 실패!');history.go(-1);</script>");
		}
		return forward;
	}

}
