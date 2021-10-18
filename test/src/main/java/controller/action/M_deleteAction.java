package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.message2.Message2DAO;
import model.message2.Message2VO;

public class M_deleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		
		Message2DAO mDAO=new Message2DAO();
		Message2VO mVO=new Message2VO();
		mVO.setMnum(Integer.parseInt(request.getParameter("mnum")));
		System.out.println("게시글 삭제");
		if(!mDAO.m_delete(mVO)) { // delete에 실패했을때
			throw new IOException("글 삭제에서 발생!");
		}
		
		
		forward.setRedirect(true);
		// true -> redirect 방식으로 보내겠다
		// false -> redirect 방식으로 보내지 않겠다 
		forward.setPath("list.do");
		return forward;
	}

}
