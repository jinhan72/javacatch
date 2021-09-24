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

		MessageDAO mDAO = new MessageDAO();
		MessageVO mVO = new MessageVO();
		mVO.setMid(Integer.parseInt(request.getParameter("mid")));
		mDAO.update(mVO);

			
		
		
		forward.setRedirect(false);
		forward.setPath("main.do");
		
		return forward;
		
		
	}

}
