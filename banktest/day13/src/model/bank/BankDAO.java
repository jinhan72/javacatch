package model.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankDAO {

	Connection conn=null;
	PreparedStatement pstmt =null;
	PreparedStatement pstmt2 =null;
	
	public Bank1VO getBank1() {
		conn=DBCP.connect();
		Bank1VO vo = null;
		try {
			String sql ="select * from bank1 where num=1";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new Bank1VO();
				vo.setNum(rs.getInt("num"));
				vo.setMname(rs.getNString("mname"));
				vo.setMoney(rs.getInt("money"));
			}
			rs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return vo;
		
	}
	
	
	public Bank2VO getBank2() {
		conn=DBCP.connect();
		Bank2VO vo = null;
		System.out.println("확인1");
		try {
			String sql ="select * from bank2 where num2=1";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("확인2");
			if(rs.next()) {
				vo = new Bank2VO();
				vo.setNum2(rs.getInt("num2"));
				vo.setMname2(rs.getNString("mname2"));
				vo.setMoney2(rs.getInt("money2"));
				System.out.println("확인3");
			}
			rs.close();
			System.out.println("확인4");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		System.out.println("확인5");
		return vo;
		
	}
	
	
	public boolean trans1(int bal) {
		System.out.println("확인1");
		boolean res = true;
		conn=DBCP.connect();
		try {
			conn.setAutoCommit(false);
			String sql1 = "update bank1 set money=money-? where num=1 ";
			String sql2 = "update bank2 set money2=money2+? where num2=1 ";
			String trans = "select money from bank1 where num=1";
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			System.out.println("확인2");
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement(trans);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("확인3");
			rs.next();
			if(rs.getInt(1)<0) {
				conn.rollback();
				System.out.println("확인5");
				return false;
			}
			else {
				conn.commit();
				rs.close();
			}

			conn.setAutoCommit(true);
			System.out.println("확3");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
			System.out.println("확인6");
			System.out.println(bal);
		}
		return res;
		
	}
	
	
	public boolean trans2(int bal) {
		boolean res = true;
		conn=DBCP.connect();
		try {
			conn.setAutoCommit(false);
			String sql1 = "update bank2 set money2=money2-? where num2=1 ";
			String sql2 = "update bank1 set money=money+? where num=1 ";
			String trans = "select money2 from bank2 where num2=1";
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement(trans);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			if(rs.getInt(1)<0) {
				conn.rollback();
				return false;
			}
			else {
				conn.commit();
				rs.close();
			}
			System.out.println("여기1");
			conn.setAutoCommit(true);
			System.out.println("여기2");
			rs.close();
			System.out.println("여기3");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return res;
		
	}
	
	
}
