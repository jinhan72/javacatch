package model.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SpringMemberDAO memberDAO;
	
	@Override
	public MemberVO getMember(MemberVO vo) {
		// return memberDAO.getMember(vo);
		try {
			return memberDAO.getMember(vo);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}
	
}
