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
		System.out.println("�Խñ� ����");
		if(!mDAO.m_delete(mVO)) { // delete�� ����������
			throw new IOException("�� �������� �߻�!");
		}
		
		
		forward.setRedirect(true);
		// true -> redirect ������� �����ڴ�
		// false -> redirect ������� ������ �ʰڴ� 
		forward.setPath("list.do");
		return forward;
	}

}
