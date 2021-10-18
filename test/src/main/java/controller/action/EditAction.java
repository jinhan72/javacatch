package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.client2.Client2VO;
import model.message2.Message2DAO;
import model.message2.Message2VO;

public class EditAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ActionForward forward= new ActionForward();
		
		Message2DAO mDAO=new Message2DAO();
		Message2VO mVO=new Message2VO();
		mVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		
		mVO=mDAO.getDBData(mVO);
	
	
		request.setAttribute("mdata", mVO);
				
		forward.setRedirect(false);
		forward.setPath("edit.jsp");
		return forward;
	}

}
