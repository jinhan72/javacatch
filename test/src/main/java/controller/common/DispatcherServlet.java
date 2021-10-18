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
		
		ActionForward forward=null; // null ���� �־���� �ϴ� ���� ???
		System.out.println("action"+action);
	
		if(action.equals("/main.do")) { // ���� 
			forward=new MainAction().execute(request, response);
		} 
		else if(action.equals("/login.do")) { // �α���
			forward=new LoginAction().execute(request, response);
		}
		else if(action.equals("/logout.do")) { // �α׾ƿ�
			System.out.println("�α׾ƿ�Ȯ��");
			forward=new LogoutAction().execute(request, response);
		}
		else if(action.equals("/list.do")) { // �Խñ� ��� ȭ��
			forward=new ListAction().execute(request, response); 
		}
		else if(action.equals("/edit.do")) { // �Խñ� ����&���� ������ �̵�
			forward=new EditAction().execute(request, response); 
		}
		else if(action.equals("/minsert.do")) { // �Խñ� �߰�
			forward=new M_insertAction().execute(request, response); 
		}
		else if(action.equals("/mdelete.do")) { // �Խñ� ����
			forward=new M_deleteAction().execute(request, response);
		}
		else if(action.equals("/signup.do")) { // ȸ������
			forward=new C_insertAction().execute(request, response);
		}
		else if(action.equals("/cdelete.do")) { // ȸ��Ż��
			forward=new C_deleteAction().execute(request, response);
		}
		else if(action.equals("/cupdate.do")) { // ȸ������ ����
			forward=new C_updateAction().execute(request, response);
		}
		
		else {
			 // ���� �������� ����
			forward=new ActionForward();
			forward.setRedirect(false);
			// ��κ� false �� �� . ������ � ������ ������ �м��� ���̱� ������?
			forward.setPath("/error/error404.jsp");
		}
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
