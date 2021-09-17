package model.msg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.common.JNDI;

public class ReplyDAO {
	Connection conn;
	PreparedStatement pstmt;
	/*	public boolean insert(ReplyVO vo) throws SQLException {
		conn = JNDI.getConnection();
		String sql = "insert into reply(mid,uid,rmsg,date) values(?,?,?,now())";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.setString(2, vo.getUid());
			pstmt.setString(3, vo.getRmsg());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}*/


	public boolean insert(ReplyVO vo) throws SQLException {
		conn = JNDI.getConnection();
		String isql = "insert into reply(mid,uid,rmsg,date) values(?,?,?,now())";
		String usql = "update message set replycount=replycount+1 where mid=?";

		try {
			conn.setAutoCommit(false); 
			pstmt = conn.prepareStatement(isql);
			pstmt.setInt(1, vo.getMid());
			pstmt.setString(2, vo.getUid());
			pstmt.setString(3, vo.getRmsg());
			System.out.println("´ñ±Û´Þ±â");
			if(pstmt.executeUpdate()== 0) {
				System.out.println(pstmt);
				conn.rollback();
				return false;
			}

			pstmt = conn.prepareStatement(usql);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
			System.out.println("ÁÁ¾Æ¿¬");
			if(pstmt.executeUpdate()==0) {
				conn.rollback();
				return false;
			}


			conn.commit(); 
			conn.setAutoCommit(true);
			System.out.println("Ä¿¹Ô");
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}


	public boolean delete(ReplyVO vo) {
		conn = JNDI.getConnection();
		String dsql = "delete from reply where rid = ?";
		try {
			pstmt = conn.prepareStatement(dsql);
			pstmt.setInt(1, vo.getRid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;  	
	}
}