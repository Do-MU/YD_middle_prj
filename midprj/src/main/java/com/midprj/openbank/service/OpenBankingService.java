package com.midprj.openbank.service;



public interface OpenBankingService {

	OpenBankingVO selectMember(OpenBankingVO vo);	
	OpenBankingVO selectMemberId(OpenBankingVO vo);	
	int insertMember(OpenBankingVO vo);	//등록
	int updateMember(OpenBankingVO vo);	//수정
	int deleteMember(OpenBankingVO vo);	//삭제
}
