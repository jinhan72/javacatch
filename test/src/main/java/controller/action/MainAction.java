package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.client2.Client2VO;
import model.message2.Message2DAO;
import model.message2.Message2VO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ActionForward forward= new ActionForward();
		
		Message2DAO mDAO=new Message2DAO();
		Client2VO cVO = null;
		
		ArrayList<Message2VO> datas=new ArrayList<Message2VO>();
	
		datas = mDAO.getDBList(cVO);
	
		
		request.setAttribute("mdatas", datas);
				
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		return forward;
	}

}
