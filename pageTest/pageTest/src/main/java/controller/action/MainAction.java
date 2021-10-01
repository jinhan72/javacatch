package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.page.PageDAO;
import common.page.PageVO;
import model.test.TestDAO;
import model.test.TestVO;

public class MainAction {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();;
		
		PageVO pageVO = new PageVO();
		PageDAO pageDAO = new PageDAO();
		
		TestDAO testDAO = new TestDAO();
		
		int page = 1;
		
		String ppage = request.getParameter("page");
		
		if(ppage != null) {
			page = Integer.parseInt(ppage);
		}
				
		pageVO.setCurPage(page);
		pageVO.setPerPage(5);
		pageVO.setPerPageSet(5);
		pageVO = pageDAO.paging(pageVO);
		
		request.setAttribute("datas", testDAO.t_selectAll(pageVO));
		request.setAttribute("paging", pageVO);
		request.setAttribute("page", page);
		
		
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		return forward;
	}

}
