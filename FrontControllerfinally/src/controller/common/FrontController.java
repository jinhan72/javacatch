package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.DeletemAction;
import controller.action.DeleterAction;
import controller.action.FavAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.NewmAction;
import controller.action.NewrpAction;
import controller.action.SignupAction;



/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController") //어노테이션이 캐치 해서 각각의 컨트롤러로 전달
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}


	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//사용자의 요청을 분석하는 메서드(액션 파라미터 분석)
		String uri = request.getRequestURI();
		System.out.println("uri"+uri);
		String cp = request.getContextPath();
		System.out.println("cp"+cp);
		String action = uri.substring(cp.length());

		ActionForward forward = null;
		//control을 매핑하는 역할
		if(action.equals("/main.do")) { // 메인페이지
			forward = new MainAction().execute(request, response);
			System.out.println("메인으로 이동");
		}
		else if(action.equals("/newrp.do")) { // 댓글
			//System.out.println("메세지 이동");
			forward = new NewrpAction().execute(request, response);
		}
		else if(action.equals("/login.do")) { // 로그인
			forward = new LoginAction().execute(request, response);
		}
		else if(action.equals("/fav.do")) { // 조아연
			forward = new FavAction().execute(request, response);
		}
		else if(action.equals("/newmsg.do")) { // 게시물
			forward = new NewmAction().execute(request, response);
		}
		else if(action.equals("/signup.do")) { // 회원가입
			forward = new SignupAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) { // 로그아웃
			forward = new LogoutAction().execute(request, response);
		}
		else if(action.equals("/delm.do")) { //게시물 삭제
			forward = new DeletemAction().execute(request, response);
		}else if(action.equals("/delr.do")) { // 댓글 삭제
			forward = new DeleterAction().execute(request, response);
		}
		else { // 에러페이지 설정 가능
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
		}
		
		if(forward!=null) {
			// 사용자에게 처리된 테이터를 출력
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}
			else{
				//pageContext.forward("main.do");
				//디스패처
				// 클라이언트로 부터 들어온 요청을 처리해서결과를 리턴해준다
				// 디스패처의 인자는 최종 경로 
				// context말고 dispatcher를 쓰는 이유
				// 데이터를 전달할때 헤더가 바뀌면 안되니까 유지 할수 있는 디스패처를 이용함
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request,response);
			}
		}
	}

}
