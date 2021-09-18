package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
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
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// [������� ��û]�� �м��ϴ� �޼���
		///// String action=request.getParameter("action");
		String uri=request.getRequestURI();
		//System.out.println("uri: "+uri);
		String cp=request.getContextPath();
		//System.out.println("cp: "+cp);
		String action=uri.substring(cp.length());
		//System.out.println("action: "+action);
		
		ActionForward forward=null;
		// control�� �����ϴ� ����
		///// if(action.equals("main")){
		if(action.equals("/main.do")) {
			forward=new MainAction().execute(request, response);
		}
		else {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("NewFile1.jsp"); // error.jsp
		}
		
		// ����ڿ��� ó���� �����͸� ���
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		}
		else {
			RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request,response);		
		}
		
	}
	
}
