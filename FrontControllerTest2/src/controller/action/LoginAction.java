package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.UserDAO;
import model.user.UserVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		UserDAO uDAO = new UserDAO();
		UserVO uVO = new UserVO();
		
		uVO.setPasswd(request.getParameter("passwd"));
		uVO.setUid(request.getParameter("uid"));
		
		if(uDAO.login(uVO)) {
			HttpSession session = request.getSession();
			session.setAttribute("seUser",uVO.getUid());
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
		}
		
		
		
		
		return forward;
		
	}

}
