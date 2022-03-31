package com.midprj.account.service;

import java.util.List;

public interface AccountMapper {
		//계좌조회
		List<SumAccMemVO> accountSelectList(String id);		
		//입금
		int Deposit(AccountVO vo);
		//출금
		int withdraw(AccountVO vo);
}
