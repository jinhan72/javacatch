package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.common.JDBC;
import oracle.jdbc.proxy.annotation.Pre;

public class MemberDAO {

	public MemberVO getMem(MemberVO vo) {
		Connection conn = JDBC.connect();
		PreparedStatement pstmt = null;
		MemberVO data=null;
		try {
			String sql="SELECT * FROM MEMBER WHERE MID=? AND MPW=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberVO();
				data.setMnum(rs.getInt("memnum"));
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
			}
			rs.close();
			
		} catch(Exception e) {
			System.out.println("getMem()에서 발생");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public boolean insertMem (MemberVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		
		try {
			String sql="INSERT INTO MEMBER VALUES((SELECT NVL(MAX(MEMNUM),0)+1 FROM MEMBER),?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.executeUpdate();
			res=true;
		} catch(Exception e) {
			System.out.println("insert()에서 발생");
			e.printStackTrace();
		}
		return res;
	}
	
	
}
