package model.message2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.client2.Client2VO;
import model.common.JNDI;

public class Message2DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	boolean flag=false;

	String m_selectAll= "select * from message2 order by mnum desc"; // 모든 게시글 보기
	String m_selectOne="select * from message2 where userID=? order by mnum desc"; // 내 게시글 보기
	String m_insert="insert into message2(mnum,userID,title,content,wdate) values (nvl((select max(mnum) from message2),0)+1, ?, ?, ?, sysdate)"; // 게시글 등록
	String m_delete="delete from message2 where mnum=?"; // 게시글 삭제
	String m_update="update message2 set title=?, content=?, wdate= sysdate where mnum=?"; // 게시글 수정
	String realSeleOne="selsct * from message2 where mnum=?";
	
	
	public Message2VO getDBData(Message2VO vo) {
		conn=JNDI.connect();
		
		try {
			pstmt=conn.prepareStatement(realSeleOne);
			pstmt.setInt(1, vo.getMnum());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo.setMnum(rs.getInt("mnum"));
				vo.setUserID(rs.getString("userID"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWdate(rs.getDate("wdate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return vo;
		
		
	}
	
	
	
	public ArrayList<Message2VO> getDBList(Client2VO vo){ // 모든 게시글 보기
		ArrayList<Message2VO> datas = new ArrayList<Message2VO>();
		conn=JNDI.connect();
		System.out.println("vo?"+vo);
		
		try {
			
			if(vo == null ) {
				pstmt=conn.prepareStatement(m_selectAll);
			}
			
			else{
				pstmt=conn.prepareStatement(m_selectOne);
				pstmt.setString(1, vo.getUserID());
			}
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Message2VO data = new Message2VO();
				data.setContent(rs.getString("content"));
				data.setMnum(rs.getInt("mnum"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
				data.setUserID(rs.getString("userID"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		System.out.println("mDAO selectAll : " + datas);
		return datas;
	
	}
	
	

	
	/*public ArrayList<Message2VO> getMyDBList(Client2VO vo){ // 내가 쓴 글 보기
		conn=JNDI.connect();
		ArrayList<Message2VO> datas= new ArrayList<Message2VO>();
		
		try {
			pstmt=conn.prepareStatement(m_selectOne);
			pstmt.setString(1, vo.getUserID());
			ResultSet rs = pstmt.executeQuery();		
			while(rs.next()) {
				Message2VO data = new Message2VO();
				data.setContent(rs.getString("content"));
				data.setMnum(rs.getInt("mnum"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
				data.setUserID(rs.getString("userID"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return datas;
	}*/
	
	 public boolean m_insert(Message2VO vo) { // 게시글 등록
		 conn=JNDI.connect();
		 
		 try {
			pstmt=conn.prepareStatement(m_insert);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		 return flag;
		 
	 }
	 
	 public boolean m_delete(Message2VO vo) { // 게시글 삭제
		 conn=JNDI.connect();
		 
		 try {
			pstmt=conn.prepareStatement(m_delete);
			pstmt.setInt(1, vo.getMnum());
			pstmt.executeUpdate();
			
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
	 }
	 
	 public boolean m_update(Message2VO vo) { // 게시글 수정 
		 conn=JNDI.connect();
		 
		 try {
			pstmt=conn.prepareStatement(m_update);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getMnum());
			pstmt.executeUpdate();
			
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
	 }
}
