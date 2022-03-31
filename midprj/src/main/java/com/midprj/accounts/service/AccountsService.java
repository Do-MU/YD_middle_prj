package com.midprj.accounts.service;

import java.util.List;

public interface AccountsService {
	
	
	List<AccountsVO> selectAccounts(AccountsVO vo);	//계좌전체조회
	AccountsVO selectOneAccount(String fintech_use_num);	//계좌단건조회
	int selectAccountInfo(AccountsVO vo);
	int insertAccounts(AccountsVO vo);	//등록

	
}
