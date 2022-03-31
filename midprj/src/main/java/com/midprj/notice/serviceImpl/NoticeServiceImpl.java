package com.midprj.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.midprj.comm.DataSource;
import com.midprj.notice.service.NoticeMapper;
import com.midprj.notice.service.NoticeService;
import com.midprj.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);
	@Override
	public List<NoticeVO> noticeSelectList() {
		
		return map.noticeSelectList();
	}
	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		
		return map.noticeSelect(vo);
	}
	@Override
	public int noticeInsert(NoticeVO vo) {
		
		return map.noticeInsert(vo);
	}
	@Override
	public int noticeUpdate(NoticeVO vo) {
		
		return map.noticeUpdate(vo);
	}
	@Override
	public int noticeDelete(int vo) {
		
		return map.noticeDelete(vo);
	}
	@Override
	public int noticeUpdateHit(int id) {
		
		return map.noticeUpdateHit(id);
	}
	@Override
	public List<NoticeVO> noticeSelectSearchList(String key, String val) {
		
		return map.noticeSelectSearchList(key, val);
	}
	@Override
	public List<NoticeVO> noticeSortList(String key) {
		
		return map.noticeSortList(key);
	}
	@Override
	public Integer getTotal() {
		// TODO Auto-generated method stub
		return map.getTotal();
	}
	@Override
	public List<NoticeVO> getList(int pageNum, int amount) {
		// TODO Auto-generated method stub
		return map.getList(pageNum, amount);
	}
	
	
	
	
}
