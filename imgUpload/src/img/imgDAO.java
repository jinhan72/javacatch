package img;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;


public class imgDAO {
	String selectAll = "SELECT * FROM IMGFILE"; 											
	String insert = "INSERT INTO IMGFILE(title,filename) VALUES(?,?)";
	String delete = "DELETE FROM IMGFILE WHERE PK = ?";						

	imgVO data = null;
	ArrayList<imgVO> datas = null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	public ArrayList<imgVO> selectDB_all(){
		datas = new ArrayList<imgVO>();
		conn = JNDI.connect();
		try {
			pstmt=conn.prepareStatement(selectAll);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				data = new imgVO();
				data.setPk(rs.getInt("pk"));
				data.setTitle(rs.getString("title"));
				data.setFilename(rs.getString("filename"));
				datas.add(data);
			}
			rs.close();
			System.out.println("imageDAO ��ȭ ��ü ����Ʈ :" + datas);
		}
		catch (SQLException e) {
			System.out.println("imageDAO ��ȭ ��ü ����Ʈ ����");
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}
		return datas;	
	}
	
	
	public Boolean m_insertDB(imgVO vo) { 	
		System.out.println("imgDAO ��ȭ ��� VO :" + vo);
		conn = JNDI.connect();
		try {
			pstmt=conn.prepareStatement(insert);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getFilename());

			if(vo.getFilename() != null) {			//��� ����
				pstmt.executeUpdate();
				System.out.println("imgDAO ��ȭ ��� ����");
				return true;
			}
		}
		catch (SQLException e) {
			System.out.println("imgDAO ��ȭ ��� ����");
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}
		return false;							//��� ����

	}
	

}
