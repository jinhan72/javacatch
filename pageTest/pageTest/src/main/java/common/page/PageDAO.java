package common.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;

public class PageDAO {
	
	
	//total �� sql count�� ���ؾߵ�
	//�ϴ� jsp�� ������� �ϴ� ���� == sql count�� �� �Խù����� ���ؼ� �� ���������� ���ؾߵ�
	//�׸��� ���������� ?�� �̻��� �Ǹ� < > �� �̿��Ͽ� ?�� ������ ���� �ѹ��� �̵� �����ؾߵ�
	//ó������, �ǳ����� �� ������ ������?
	//���� ���������� get ����� ���� �츮���� ���� �������� �ٰŴ�
	//�κ� ���������� Ȯ���غ��� ���� ������ ������ �޾ƿ�
	
	
	String count = "SELECT COUNT(*) FROM TEST";		// �� �Խù� ��
	
	PageVO data = null;
	
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	/*
	int curPage;	//���� ������ ��Ʈ�ѷ����� �޾ƿ�
	int perPage;	//���� ������ ��Ʈ�ѷ����� �޾ƿ� (�������� �� �Խù� ��)
	int perPageSet; //���� ������ ��Ʈ�ѷ����� �޾ƿ� (����¡ ���������� ����)
	
	int total;		//count sql ����Ͽ� set
	int startPage;	//curPage�� �̿��Ͽ� ����� set
	int endPage;	//curPage�� �̿��Ͽ� ����� set
	int lastPage;	//count sql ����Ͽ� set
	int start;		//curPage�� �̿��Ͽ� ����� set
	int end;		//curPage�� �̿��Ͽ� ����� set
*/	
	
	
	public PageVO paging(PageVO vo) {		
		System.out.println("pageDAO :" + vo);	
		conn = JNDI.connect();
		try {	//�� �Խù� �� count
			pstmt=conn.prepareStatement(count);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setTotal(rs.getInt(1));		//�ѰԽù��� vo�� set
			}		
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		
		System.out.println("pageDAO count :" + vo.getTotal());
		
		
		vo.setLastPage(vo.getTotal()/vo.getPerPageSet()+1);	//������ ������ set	
		vo.setStart(vo.getCurPage()*vo.getPerPage());		//�������� ������ �Խù� ����
		vo.setEnd(vo.getStart()+vo.getPerPage());			//�������� ������ �Խù� ��		sql�� �� �͵�		
		
		
	
		vo.setStartPage((vo.getCurPage()-1)/vo.getPerPageSet()*vo.getPerPageSet()+1);
		if(vo.getStartPage() < 1) {
			vo.setStartPage(1);
		}
		vo.setEndPage(vo.getStartPage()+vo.getPerPageSet()-1);				
		if(vo.getEndPage() > vo.getLastPage()) {
			vo.setEndPage(vo.getLastPage());
		}
		
		System.out.println("pageDAO af :" + vo);
		
	
		
		
		return vo;
		
	}
	
	//�̰� ��Ʈ�ѷ����� �ؾߵǴ� �κ�
	
	

	
	

}
