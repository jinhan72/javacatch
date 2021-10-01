package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.MainAction;

//"모든" 클라이언트의 요청이 현재 서블릿으로 들어오게 되고, 이곳에서 요청에 따라 control.jsp로 이동하도록 함

/*@WebServlet("*.do")*/ // 간단하게 이 방식도 가능
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		/* 1. 클라이언트의 "요청"을 분석하는 함수 */
		String uri = request.getRequestURI(); // uri : /FrontController/main.do
		String cp = request.getContextPath(); // cp :/FrontController
		String action = uri.substring(cp.length()); // action : /main/do - 실제 액션값만 추출 -> 유지 보수성 증가
		
		/* 2. control을 매핑하는 역할 */
		ActionForward forward = null;
		
		// 회원, 리뷰 관련 액션 처리
		
		if (action.equals("/main.do")) {
			forward = new MainAction().execute(request, response);
		
		} else { // 만약 잘못된 action값인 경우 즉, null인 경우 에러 페이지로 연결
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/errer404.jsp");
		}
		
		/* 3. 클라이언트에게 결과 화면 출력 */
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
