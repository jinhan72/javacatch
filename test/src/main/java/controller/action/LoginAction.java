package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.client2.Client2DAO;
import model.client2.Client2VO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;
		
		Client2DAO cDAO=new Client2DAO();
		Client2VO cVO=new Client2VO();
		
		cVO.setUserID(request.getParameter("userID"));
		cVO.setUserPW(request.getParameter("userPW"));
		
		cVO = cDAO.login(cVO); // 재사용
		if(cVO!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("seUser", cVO);
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("list.do");
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out=response.getWriter();
	        out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
		}
		
		
		return forward;
	}

}
