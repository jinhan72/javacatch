package img;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String fileName = request.getParameter("file");
          System.out.println(fileName);
          ServletContext context = getServletContext(); //어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨. 
          String saveDir = context.getRealPath("images"); //절대경로를 가져옴
          System.out.println("절대경로 >> " + saveDir);
          int maxSize = 3*1024*1024; // 3MB
          String encoding = "UTF-8";
          MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
          
          imgVO data = new imgVO();
          data.setTitle(multi.getParameter("title"));
          data.setFilename(multi.getFilesystemName("file"));
          
          
          
          imgDAO dao = new imgDAO();
          
          String moveUrl ="";
          
          if(dao.m_insertDB(data)) {
        	  System.out.println("업로드 성공");
        	  moveUrl = "Select";
          }
          else {
        	  System.out.println("업로드 실패");
        	  moveUrl = "form.jsp";
          }
          response.sendRedirect(moveUrl);
          
	}

}
