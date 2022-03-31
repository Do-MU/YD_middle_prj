package com.midprj.member.service;




public interface MemberService {
	MemberVO selectMember(MemberVO vo);	//한명분 데이터 또는 로그인 처리
	MemberVO selectMemberId(MemberVO vo);	//Id 조회
	int insertMember(MemberVO vo);	//등록
	int updateMember(MemberVO vo);	//수정
	int deleteMember(MemberVO vo);	//삭제
	
	boolean isIdCheck(String str);	//아이디 중복체크

}
