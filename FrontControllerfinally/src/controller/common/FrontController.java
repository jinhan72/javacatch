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
@WebServlet("/FrontController") //������̼��� ĳġ �ؼ� ������ ��Ʈ�ѷ��� ����
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
		//������� ��û�� �м��ϴ� �޼���(�׼� �Ķ���� �м�)
		String uri = request.getRequestURI();
		System.out.println("uri"+uri);
		String cp = request.getContextPath();
		System.out.println("cp"+cp);
		String action = uri.substring(cp.length());

		ActionForward forward = null;
		//control�� �����ϴ� ����
		if(action.equals("/main.do")) { // ����������
			forward = new MainAction().execute(request, response);
			System.out.println("�������� �̵�");
		}
		else if(action.equals("/newrp.do")) { // ���
			//System.out.println("�޼��� �̵�");
			forward = new NewrpAction().execute(request, response);
		}
		else if(action.equals("/login.do")) { // �α���
			forward = new LoginAction().execute(request, response);
		}
		else if(action.equals("/fav.do")) { // ���ƿ�
			forward = new FavAction().execute(request, response);
		}
		else if(action.equals("/newmsg.do")) { // �Խù�
			forward = new NewmAction().execute(request, response);
		}
		else if(action.equals("/signup.do")) { // ȸ������
			forward = new SignupAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) { // �α׾ƿ�
			forward = new LogoutAction().execute(request, response);
		}
		else if(action.equals("/delm.do")) { //�Խù� ����
			forward = new DeletemAction().execute(request, response);
		}else if(action.equals("/delr.do")) { // ��� ����
			forward = new DeleterAction().execute(request, response);
		}
		else { // ���������� ���� ����
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
		}
		
		if(forward!=null) {
			// ����ڿ��� ó���� �����͸� ���
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}
			else{
				//pageContext.forward("main.do");
				//����ó
				// Ŭ���̾�Ʈ�� ���� ���� ��û�� ó���ؼ������ �������ش�
				// ����ó�� ���ڴ� ���� ��� 
				// context���� dispatcher�� ���� ����
				// �����͸� �����Ҷ� ����� �ٲ�� �ȵǴϱ� ���� �Ҽ� �ִ� ����ó�� �̿���
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request,response);
			}
		}
	}

}
