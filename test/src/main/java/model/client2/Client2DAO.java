package model.client2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;

public class Client2DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	String login="select * from client2 where userID=? and userPW=?"; //로그인
	String c_insert="insert into client2 values (?,?,?)"; // 회원가입
	String c_delete="delete from client2 where userID=?"; // 회원탈퇴
	String c_update="update client2 set userID=?, userPW=?, name=? where userID=?"; // 회원정보수정

	boolean flag=false;

	public Client2VO login(Client2VO vo) {  // 로그인
		conn=JNDI.connect();

		Client2VO outvo = null;

		try {
			pstmt=conn.prepareStatement(login);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			rs=pstmt.executeQuery();
			if (rs.next()) { // 일치하는 회원 ID,PW가 있다면 ... 
				outvo = new Client2VO();
				outvo.setUserID(rs.getString("userID"));
				outvo.setUserPW(rs.getString("userPW"));
				outvo.setName(rs.getString("name"));
			} // 이 정보를 받아와서 return 해주면 회원정보 수정을 할때 편리
			// return flag를 하면 ID값만 받아오니까 .. .
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return outvo;

	}

	public boolean insert(Client2VO vo) { // 회원가입
		conn=JNDI.connect();
		try {
			pstmt =conn.prepareStatement(c_insert);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();

			System.out.println("cDAO확인"+ vo);
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		
		return flag;

	}

	public boolean delete(Client2VO vo) { // 회원 탈퇴
		conn=JNDI.connect();

		try {
			pstmt=conn.prepareStatement(c_delete);
			pstmt.setString(1, vo.getUserID());
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

	public boolean update(Client2VO vo) { // 회원 정보 수정
		conn=JNDI.connect();

		try {
			pstmt=conn.prepareStatement(c_update);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getUserID());
			pstmt.executeUpdate();

			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}

		return flag;

	}
}


