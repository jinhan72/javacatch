package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.message2.Message2DAO;
import model.message2.Message2VO;

public class M_insertAction  implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();


		Message2DAO mDAO=new Message2DAO();
		Message2VO mVO=new Message2VO();
		mVO.setTitle(request.getParameter("title"));
		mVO.setContent(request.getParameter("content"));
		mVO.setUserID(request.getParameter("userID"));
		if(!mDAO.m_insert(mVO)) {
			throw new IOException("글 등록에서 발생!");
		}

		forward.setRedirect(true);
		forward.setPath("list.do");
		return forward;
	}

}
