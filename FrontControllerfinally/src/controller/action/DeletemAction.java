package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageDAO;
import model.msg.MessageVO;

public class DeletemAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		MessageDAO mDAO = new MessageDAO();
		MessageVO mVO = new MessageVO();
		mVO.setMid(Integer.parseInt(request.getParameter("mid")));
		if(!mDAO.delete(mVO)) {
			
			throw new IOException("deletem에서 발생!");
		}
		
		forward.setRedirect(false);
		forward.setPath("main.do");
		return forward;
	}

}
