package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.ReplyDAO;
import model.msg.ReplyVO;

public class DeleterAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ReplyDAO rDAO = new ReplyDAO();
		ReplyVO rVO = new ReplyVO();
		
		rVO.setRid(Integer.parseInt(request.getParameter("rid")));
		if(!rDAO.delete(rVO)) {
			throw new IOException("deleter에서 발생!");
		}
		
		forward.setRedirect(false);
		forward.setPath("main.do");
		return forward;
	}

}
