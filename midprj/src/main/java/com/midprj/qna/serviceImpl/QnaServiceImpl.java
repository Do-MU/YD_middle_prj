package com.midprj.qna.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.midprj.comm.DataSource;
import com.midprj.qna.service.QnaMapper;
import com.midprj.qna.service.QnaService;
import com.midprj.qna.service.QnaVO;


public class QnaServiceImpl implements QnaService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private QnaMapper map = sqlSession.getMapper(QnaMapper.class);
	@Override
	public List<QnaVO> qnaSelectList(String memberId) {
		
		return map.qnaSelectList(memberId);
	}
	@Override
	public QnaVO qnaSelect(QnaVO vo) {
		
		return map.qnaSelect(vo);
	}
	@Override
	public int qnaInsert(QnaVO vo) {
		
		return map.qnaInsert(vo);
	}
	@Override
	public int qnaUpdate(QnaVO vo) {
		
		return map.qnaUpdate(vo);
	}
	@Override
	public List<QnaVO> getList(int pageNum, int amount, String memberId) {
		// TODO Auto-generated method stub
		return map.getList(pageNum, amount,memberId);
	}
	@Override
	public Integer getTotal() {
		return map.getTotal();
	}
	
	
}
