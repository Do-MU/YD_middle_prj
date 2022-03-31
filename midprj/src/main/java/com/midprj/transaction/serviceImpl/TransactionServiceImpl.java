package com.midprj.transaction.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.midprj.comm.DataSource;
import com.midprj.transaction.service.TransactionMapper;
import com.midprj.transaction.service.TransactionService;
import com.midprj.transaction.service.TransactionVO;

public class TransactionServiceImpl implements TransactionService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private TransactionMapper map = sqlSession.getMapper(TransactionMapper.class);
	
	@Override
	public int insertTransactions(TransactionVO vo) {
		// TODO Auto-generated method stub
		return map.insertTransactions(vo);
	}

	@Override
	public List<TransactionVO> selectTransactions(TransactionVO vo) {
		// TODO Auto-generated method stub
		return map.selectTransactions(vo);
	}

}
