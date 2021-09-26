package img;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Select
 */
@WebServlet("/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //DB에 저장된 file정보를 모두 검색해서 jsp로 전송
        imgDAO dao = new imgDAO();
        
        try{
              ArrayList<imgVO> datas = dao.selectDB_all();
              
              if(datas!=null) {
                    request.setAttribute("datas", datas);
                                         
              }else {
                    System.out.println("비었습니다");
              }
              
              RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
              dis.forward(request, response);
              
        }catch(Exception e) {
              e.printStackTrace();
        }
  
  }
	

}
