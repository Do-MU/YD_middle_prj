package com.midprj.openbank.service;

public interface OpenBankingMapper {
	OpenBankingVO selectMember(OpenBankingVO vo);	//한명분 데이터 또는 로그인 처리
	OpenBankingVO selectMemberId(OpenBankingVO vo);	//Id 조회
	int insertMember(OpenBankingVO vo);	//등록
	int updateMember(OpenBankingVO vo);	//수정
	int deleteMember(OpenBankingVO vo);	//삭제

}
