package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.C_deleteAction;
import controller.action.C_insertAction;
import controller.action.C_updateAction;
import controller.action.EditAction;
import controller.action.ListAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.M_deleteAction;
import controller.action.M_insertAction;
import controller.action.MainAction;

/**
 * Servlet implementation class DispatcherServlet
 */
// @WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri= request.getRequestURI();
		String cp=request.getContextPath();
		String action = uri.substring(cp.length());
		
		ActionForward forward=null; // null 값을 넣어줘야 하는 이유 ???
		System.out.println("action"+action);
	
		if(action.equals("/main.do")) { // 메인 
			forward=new MainAction().execute(request, response);
		} 
		else if(action.equals("/login.do")) { // 로그인
			forward=new LoginAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) { // 로그아웃
			System.out.println("로그아웃확인");
			forward=new LogoutAction().execute(request, response);
		}
		else if(action.equals("/list.do")) { // 게시글 목록 화면
			forward=new ListAction().execute(request, response); 
		}
		else if(action.equals("/edit.do")) { // 게시글 수정&삭제 페이지 이동
			forward=new EditAction().execute(request, response); 
		}
		else if(action.equals("/minsert.do")) { // 게시글 추가
			forward=new M_insertAction().execute(request, response); 
		}
		else if(action.equals("/mdelete.do")) { // 게시글 삭제
			forward=new M_deleteAction().execute(request, response);
		}
		else if(action.equals("/signup.do")) { // 회원가입
			forward=new C_insertAction().execute(request, response);
		}
		else if(action.equals("/cdelete.do")) { // 회원탈퇴
			forward=new C_deleteAction().execute(request, response);
		}
		else if(action.equals("/cupdate.do")) { // 회원정보 수정
			forward=new C_updateAction().execute(request, response);
		}
		
		else {
			 // 에러 페이지랑 연결
			forward=new ActionForward();
			forward.setRedirect(false);
			// 대부분 false 를 씀 . 앞으로 어떤 에러가 들어올지 분석할 것이기 때문에?
			forward.setPath("/error/error404.jsp");
		}
		if (forward != null) { // 만약 forward == null이면 위의 액션처리가 제대로 되지 않은 것!
			if (forward.isRedirect()) { // redirect 방식
				response.sendRedirect(forward.getPath());
			} else { // forward 방식 - 요청 헤더를 유지하여 페이지 이동
				System.out.println("!!!!");
				// Dispatcher	
				// : 클라이언트로부터 최초에 들어온 요청을 JSP/Servlet 내에서 원하는 자원으로 요청을 넘기는 역할을 수행하거나,
				//   특정 자원에 처리를 요청하고 처리 결과를 얻어오는 기능을 수행하는 클래스
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath()); // 최종 경로
				dispatcher.forward(request, response);
			}
		}
	
	}

}
