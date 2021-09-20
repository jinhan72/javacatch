package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageDAO;
import model.msg.MessageVO;
import model.msg.MsgSet;
import model.user.UserDAO;
import model.user.UserVO;

public class FavAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ActionForward forward = new ActionForward();
		
		String mcntt = request.getParameter("mcnt");
		int mcnt=1;
		if(mcntt!=null) {
			mcnt=Integer.parseInt(mcntt);
		}
		
		MessageDAO mDAO = new MessageDAO();
		UserDAO uDAO = new UserDAO();
		mDAO.update((MessageVO)request.getAttribute("mvo"));
		String selUser = request.getParameter("selUser");
	
		ArrayList<MsgSet> datas = mDAO.selectAll(selUser, mcnt);
		ArrayList<UserVO> newUsers=uDAO.selectAll();
		
		request.setAttribute("datas", datas);
		request.setAttribute("selUSer", selUser);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("mcnt", mcnt);
		
		
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		
		return forward;
		
		
	}

}
