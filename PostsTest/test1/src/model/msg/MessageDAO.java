package model.msg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.sun.java_cup.internal.runtime.Symbol;

import model.common.JNDI;

public class MessageDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	public ArrayList<MsgSet> selectAll(String uid, int cnt){
		ArrayList<MsgSet> datas = new ArrayList<MsgSet>(); // datas == 게시물과 댓글을 저장함
		conn = JNDI.getConnection();
		String sql;
		try {
			// no회원
		if((uid==null) ||(uid.equals("") )) { // null은 == 가능 한데 .eq은 안됨
			sql="select * from message order by date desc limit 0,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cnt);
		}
		//회원
		else {
			sql="select * from message where uid=? order by date asc limit 0,?";
			System.out.println("mDao :"+ uid);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setInt(2, cnt);
		}
		
		// 전체 게시물
		rs = pstmt.executeQuery();
		while(rs.next()) {
			MsgSet ms = new MsgSet();
			MessageVO m = new MessageVO();
			ArrayList<ReplyVO> rlist = new ArrayList<ReplyVO>();
			
			//m에 rs로 get한 애들을 넣어줌
			m.setMid(rs.getInt("mid"));
			m.setMsg(rs.getString("msg"));
			m.setFavcount(rs.getInt("favcount"));
			m.setUid(rs.getString("uid"));
			m.setDate(rs.getDate("date"));
			//System.out.println("1");
			
			// 
			String rsql = "select * from reply where mid = ? order by date desc";
			pstmt= conn.prepareStatement(rsql);
			pstmt.setInt(1, rs.getInt("mid"));
			ResultSet rrs = pstmt.executeQuery();
			int rcnt = 0; // 조횟수? 조회수?
			while(rrs.next()) {
				//System.out.println("2");
				ReplyVO r = new ReplyVO(); // rrs로 받아온 애들 r에 저장
				r.setDate(rrs.getDate("date"));
				r.setMid(rrs.getInt("mid"));
				r.setRid(rrs.getInt("rid"));
				r.setRmsg(rrs.getString("rmsg"));
				r.setUid(rrs.getString("uid"));
				rlist.add(r);
				rcnt++;
			}
			m.setReplycount(rcnt); // 이거뭐임?
			
			// MsgSet에서 만든 m,rlist들에게 m에는 게시물 값, rlist에는 댓글 값을 넣어 ms에 넣어줌 넣은 ms를 datas에 저장
			ms.setM(m);
			//System.out.println(" rlist"+rlist);
			ms.setRlist(rlist);
			datas.add(ms);
			rrs.close();
			
		}
		rs.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return datas;
		
	}
	public boolean insert(MessageVO vo) {
		conn = JNDI.getConnection();
		String sql = "insert into message(uid, msg, date) values(?,?,now())";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUid());
			pstmt.setString(2, vo.getMsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
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
	public boolean delete(MessageVO vo) {
		conn = JNDI.getConnection();
		String sql = "delete from message where mid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
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
	public void update(MessageVO vo) {
		conn = JNDI.getConnection();
		String sql = "update message set favcount=favcount+1 where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
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
	}
}
