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
		//댓글
		rVO.setMid(Integer.parseInt(request.getParameter("mid")));
		rVO.setRmsg(request.getParameter("rmsg"));
		rVO.setUid(request.getParameter("uid"));
		
		try {
			if(rDAO.insert(rVO)) {
				
			}
		} catch (SQLException e) {
			System.out.println("댓글다는 중 오류");
			e.printStackTrace();
		}
		
		forward.setRedirect(false);
		forward.setPath("main.do");
		return forward;
	}

}
