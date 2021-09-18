package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageDAO;
import model.msg.MsgSet;
import model.user.UserDAO;
import model.user.UserVO;

public class FavAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=new ActionForward();
		
		String mcntt=request.getParameter("mcnt");
		int mcnt=3;
		if(mcntt!=null){
			mcnt=Integer.parseInt(mcntt);
		}
				
		String selUser=request.getParameter("selUser");
		
		MessageDAO mDAO=new MessageDAO();
		UserDAO uDAO=new UserDAO();
		mDAO.update(()request.getAttribute("mVO"));
		ArrayList<MsgSet> datas=mDAO.selectAll(selUser, mcnt);
		ArrayList<UserVO> newUsers=uDAO.selectAll();
		
		request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("selUser", selUser);
		request.setAttribute("mcnt", mcnt);
		
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
