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

//"���" Ŭ���̾�Ʈ�� ��û�� ���� �������� ������ �ǰ�, �̰����� ��û�� ���� control.jsp�� �̵��ϵ��� ��

/*@WebServlet("*.do")*/ // �����ϰ� �� ��ĵ� ����
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
		
		/* 1. Ŭ���̾�Ʈ�� "��û"�� �м��ϴ� �Լ� */
		String uri = request.getRequestURI(); // uri : /FrontController/main.do
		String cp = request.getContextPath(); // cp :/FrontController
		String action = uri.substring(cp.length()); // action : /main/do - ���� �׼ǰ��� ���� -> ���� ������ ����
		
		/* 2. control�� �����ϴ� ���� */
		ActionForward forward = null;
		
		// ȸ��, ���� ���� �׼� ó��
		
		if (action.equals("/main.do")) {
			forward = new MainAction().execute(request, response);
		
		} else { // ���� �߸��� action���� ��� ��, null�� ��� ���� �������� ����
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/errer404.jsp");
		}
		
		/* 3. Ŭ���̾�Ʈ���� ��� ȭ�� ��� */
		if (forward != null) { // ���� forward == null�̸� ���� �׼�ó���� ����� ���� ���� ��!
			if (forward.isRedirect()) { // redirect ���
				response.sendRedirect(forward.getPath());
			} else { // forward ��� - ��û ����� �����Ͽ� ������ �̵�
				System.out.println("!!!!");
				// Dispatcher
				// : Ŭ���̾�Ʈ�κ��� ���ʿ� ���� ��û�� JSP/Servlet ������ ���ϴ� �ڿ����� ��û�� �ѱ�� ������ �����ϰų�,
				//   Ư�� �ڿ��� ó���� ��û�ϰ� ó�� ����� ������ ����� �����ϴ� Ŭ����
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath()); // ���� ���
				dispatcher.forward(request, response);
			}
		}
	}
}
