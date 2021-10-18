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

	String login="select * from client2 where userID=? and userPW=?"; //�α���
	String c_insert="insert into client2 values (?,?,?)"; // ȸ������
	String c_delete="delete from client2 where userID=?"; // ȸ��Ż��
	String c_update="update client2 set userID=?, userPW=?, name=? where userID=?"; // ȸ����������

	boolean flag=false;

	public Client2VO login(Client2VO vo) {  // �α���
		conn=JNDI.connect();

		Client2VO outvo = null;

		try {
			pstmt=conn.prepareStatement(login);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			rs=pstmt.executeQuery();
			if (rs.next()) { // ��ġ�ϴ� ȸ�� ID,PW�� �ִٸ� ... 
				outvo = new Client2VO();
				outvo.setUserID(rs.getString("userID"));
				outvo.setUserPW(rs.getString("userPW"));
				outvo.setName(rs.getString("name"));
			} // �� ������ �޾ƿͼ� return ���ָ� ȸ������ ������ �Ҷ� ��
			// return flag�� �ϸ� ID���� �޾ƿ��ϱ� .. .
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return outvo;

	}

	public boolean insert(Client2VO vo) { // ȸ������
		conn=JNDI.connect();
		try {
			pstmt =conn.prepareStatement(c_insert);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();

			System.out.println("cDAOȮ��"+ vo);
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		
		return flag;

	}

	public boolean delete(Client2VO vo) { // ȸ�� Ż��
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

	public boolean update(Client2VO vo) { // ȸ�� ���� ����
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


