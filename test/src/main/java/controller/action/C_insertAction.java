package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.client2.Client2DAO;
import model.client2.Client2VO;


public class C_insertAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward = new ActionForward();
		
		Client2DAO cDAO=new Client2DAO();
		Client2VO cVO= new Client2VO();
		
		cVO.setUserID(request.getParameter("userID"));
		cVO.setUserPW(request.getParameter("userPW"));
		cVO.setName(request.getParameter("name"));
		if(!cDAO.insert(cVO)) { 
			throw new IOException("회원가입에서 발생!");
		}
		
		forward.setRedirect(true);
		forward.setPath("main.do"); 
		return forward;
	}

}
