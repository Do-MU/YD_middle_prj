package com.midprj.transaction.service;

import java.util.List;

public interface TransactionMapper {
	int insertTransactions(TransactionVO vo);	//등록
	List<TransactionVO> selectTransactions(TransactionVO vo);	//거래내역전체조회

}
