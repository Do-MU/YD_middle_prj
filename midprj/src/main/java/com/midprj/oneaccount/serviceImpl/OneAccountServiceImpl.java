package com.midprj.oneaccount.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import com.midprj.comm.DataSource;
import com.midprj.oneaccount.service.OneAccountMapper;
import com.midprj.oneaccount.service.OneAccountService;
import com.midprj.oneaccount.service.OneAccountVO;

public class OneAccountServiceImpl implements OneAccountService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private OneAccountMapper map = sqlSession.getMapper(OneAccountMapper.class);

	@Override
	public int insertOneAccount(OneAccountVO vo) {
		// TODO Auto-generated method stub
		return map.insertOneAccount(vo);
	}

	@Override
	public OneAccountVO selectOneAccount(String fintech_use_num) {
		// TODO Auto-generated method stub
		return null;
	}

}
