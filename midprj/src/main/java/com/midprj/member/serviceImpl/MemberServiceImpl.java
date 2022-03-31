package com.midprj.member.serviceImpl;





import org.apache.ibatis.session.SqlSession;

import com.midprj.comm.DataSource;
import com.midprj.member.service.MemberMapper;
import com.midprj.member.service.MemberVO;
import com.midprj.member.service.MemberService;;


public class MemberServiceImpl implements MemberService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);


	@Override
	public MemberVO selectMember(MemberVO vo) {
		// 한명 또는 로그인
		return map.selectMember(vo);
	}
	@Override
	public MemberVO selectMemberId(MemberVO vo) {
		return map.selectMemberId(vo);
	}
	@Override
	public int insertMember(MemberVO vo) {
		// 회원 등록
		return map.insertMember(vo);
	}

	@Override
	public int updateMember(MemberVO vo) {
		// 회원 정보 변경
		return map.updateMember(vo);
	}

	@Override
	public int deleteMember(MemberVO vo) {
		// 회원 삭제
		return map.deleteMember(vo);
	}

	@Override
	public boolean isIdCheck(String str) {
		// 아이디 중복체크
		return map.isIdCheck(str);
	}


	
}
