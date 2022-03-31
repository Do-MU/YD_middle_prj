package com.midprj.oneaccount.service;


public interface OneAccountService {
	int insertOneAccount(OneAccountVO vo);	//등록
	OneAccountVO selectOneAccount(String fintech_use_num);	//계좌단건조회
}
