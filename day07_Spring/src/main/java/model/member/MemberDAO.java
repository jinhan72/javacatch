package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("memberDAO")
public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String getMemberSQL="select * from member where id=? and password=?";
	
	public MemberVO getBoard(MemberVO vo) {
		// 로그인에 성공한다면, MemberVO 객체가 리턴(반환)
		// 실패한다면, 리턴이 null
		MemberVO data=null;
		
		System.out.println("MemberDAO로 get");

		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getMemberSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberVO();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPassword(rs.getString("password"));
				data.setRole(rs.getString("role"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt, rs);
		}
		
		return data;
	}
}
