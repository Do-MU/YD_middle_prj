package com.midprj.accounts.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.midprj.accounts.service.AccountsMapper;
import com.midprj.accounts.service.AccountsService;
import com.midprj.accounts.service.AccountsVO;
import com.midprj.comm.DataSource;

public class AccountsServiceImpl implements AccountsService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private AccountsMapper map = sqlSession.getMapper(AccountsMapper.class);

	@Override
	public List<AccountsVO> selectAccounts(AccountsVO vo) {

		return map.selectAccounts(vo);
	}

	@Override
	public AccountsVO selectOneAccount(String fintech_use_num) {
		
		return map.selectOneAccount(fintech_use_num);
	}

	@Override
	public int selectAccountInfo(AccountsVO vo) {
		
		return map.selectAccountInfo(vo);
	}
	
	@Override
	public int insertAccounts(AccountsVO vo) {
		// TODO Auto-generated method stub
		
		return map.insertAccounts(vo);
	}

	@Override
	public int updateAccounts(AccountsVO vo) {
		
		return map.updateAccounts(vo);
	}

}
