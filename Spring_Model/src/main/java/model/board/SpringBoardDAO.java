package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
		data.setId(rs.getInt("id"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setContent(rs.getString("content"));
		data.setWdate(rs.getDate("wdate"));
		return data;
	}
	
}
// 1. extends ��ӹ޾Ƽ� ����
// 2. JdbcTemplate�� <bean>���, ���������Թ޾� ���
@Repository
public class SpringBoardDAO {

	private final String insertSQL="insert into board (id,title,writer,content) values((select nvl(max(id),0)+1 from board),?,?,?)";
	private final String updateSQL="update board set title=?,content=? where id=?";
	private final String deleteSQL="delete board where id=?";
	private final String getBoardSQL="select * from board where id=?";
	private final String getBoardListSQL="select * from board order by id desc";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("jdbcTemplate���� insert");
		jdbcTemplate.update(insertSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("jdbcTemplate���� update");
		jdbcTemplate.update(updateSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("jdbcTemplate���� delete");
		jdbcTemplate.update(deleteSQL,vo.getId());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("jdbcTemplate���� getBoardList");
		return jdbcTemplate.query(getBoardListSQL,new BoardRowMapper());
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("jdbcTemplate���� getBoard");
		Object[] args= { vo.getId() };
		return jdbcTemplate.queryForObject(getBoardSQL,args,new BoardRowMapper());
	}
	
}
