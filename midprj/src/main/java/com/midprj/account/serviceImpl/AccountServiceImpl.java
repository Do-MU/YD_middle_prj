package com.midprj.account.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.midprj.account.service.AccountMapper;
import com.midprj.account.service.AccountService;
import com.midprj.account.service.AccountVO;
import com.midprj.account.service.SumAccMemVO;
import com.midprj.comm.DataSource;

public class AccountServiceImpl implements AccountService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private AccountMapper map = sqlSession.getMapper(AccountMapper.class);
	@Override
	public List<SumAccMemVO> accountSelectList(String id) {
		// TODO Auto-generated method stub
		return map.accountSelectList(id);
	}
	@Override
	public int Deposit(AccountVO vo) {
		// TODO Auto-generated method stub
		return map.Deposit(vo);
	}
	@Override
	public int withdraw(AccountVO vo) {
		// TODO Auto-generated method stub
		return map.withdraw(vo);
	}
	
}
