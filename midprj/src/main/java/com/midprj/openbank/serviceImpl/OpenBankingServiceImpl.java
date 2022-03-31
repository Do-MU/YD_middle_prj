package com.midprj.openbank.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import com.midprj.comm.DataSource;

import com.midprj.openbank.service.OpenBankingMapper;
import com.midprj.openbank.service.OpenBankingService;
import com.midprj.openbank.service.OpenBankingVO;

public class OpenBankingServiceImpl implements OpenBankingService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private OpenBankingMapper map = sqlSession.getMapper(OpenBankingMapper.class); 

	@Override
	public OpenBankingVO selectMember(OpenBankingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpenBankingVO selectMemberId(OpenBankingVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(OpenBankingVO vo) {
		return map.insertMember(vo);
	}

	@Override
	public int updateMember(OpenBankingVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(OpenBankingVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
