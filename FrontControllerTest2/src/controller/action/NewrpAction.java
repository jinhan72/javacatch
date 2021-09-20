package controller.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageDAO;
import model.msg.MsgSet;
import model.msg.ReplyDAO;
import model.msg.ReplyVO;
import model.user.UserDAO;
import model.user.UserVO;

public class NewrpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		// 1. rVO만들수있도록 get()
		// 2. rDAO로 insert()
		ReplyDAO rDAO = new ReplyDAO();
		ReplyVO rVO = new ReplyVO();
		
		rVO.setMid(Integer.parseInt(request.getParameter("mid")));
		rVO.setRmsg(request.getParameter("rmsg"));
		rVO.setUid(request.getParameter("uid"));
		
		try {
			if(!rDAO.insert(rVO)) {
				throw new IOException("newrp에서 발생!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String mcntt = request.getParameter("mcnt");
		int mcnt=3;
		if(mcntt!=null) {
			mcnt = Integer.parseInt(mcntt);
		}
		
		String selUser = request.getParameter("selUser");
		
		MessageDAO mDAO = new MessageDAO();
		UserDAO uDAO = new UserDAO();
		ArrayList<MsgSet> datas = mDAO.selectAll(selUser, mcnt);
		ArrayList<UserVO> newUsers=uDAO.selectAll();
		
		request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("selUser", selUser);
		request.setAttribute("mcnt", mcnt);
		
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		return forward;
	}

}
