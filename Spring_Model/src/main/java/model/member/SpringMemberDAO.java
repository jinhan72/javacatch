package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



class MemberRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setId(rs.getString("id"));
		data.setName(rs.getString("name"));
		data.setPassword(rs.getString("password"));
		data.setRole(rs.getString("role"));
		return data;
	}
}
@Repository 
public class SpringMemberDAO {
	private final String getMemberSQL="select * from member where id=? and password=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MemberVO getBoard(MemberVO vo) {
		System.out.println("Spring에서 제공해주는 JDBC템플릿");
		Object[] args = {vo.getId(),vo.getPassword()};
		return jdbcTemplate.queryForObject(getMemberSQL, args, new MemberRowMapper());
		
	}
	
	
}
