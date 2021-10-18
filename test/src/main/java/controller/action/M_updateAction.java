package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.message2.Message2DAO;
import model.message2.Message2VO;

public class M_updateAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();


		Message2DAO mDAO=new Message2DAO();
		Message2VO mVO=new Message2VO();
		
		mVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		mVO.setTitle(request.getParameter("title"));
		mVO.setContent(request.getParameter("content"));
		mVO.setUserID(request.getParameter("userID"));
		
		System.out.println("mVO: "+mVO);
		
		if(!mDAO.m_update(mVO)) {
			throw new IOException("글 수정에서 발생!");
		} else {
			forward.setRedirect(true);
			forward.setPath("list.do");
			
		}

		return forward;
	}
}
