package com.midprj.comment.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.midprj.comm.DataSource;
import com.midprj.comment.service.CommentMapper;
import com.midprj.comment.service.CommentService;
import com.midprj.comment.service.CommentVO;

public class CommentServiceImpl implements CommentService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private CommentMapper map = sqlSession.getMapper(CommentMapper.class);
	
	@Override
	public List<CommentVO> commentSelectList(int noticeId) {
		// TODO Auto-generated method stub
		return map.commentSelectList(noticeId);
	}
	@Override
	public int commentInsert(CommentVO vo) {
		// TODO Auto-generated method stub
		return map.commentInsert(vo);
	}
	@Override
	public int commentUpdate(CommentVO vo) {
		// TODO Auto-generated method stub
		return map.commentUpdate(vo);
	}
	@Override
	public int commentDelete(CommentVO vo) {
		// TODO Auto-generated method stub
		return map.commentDelete(vo);
	}
	
	
}
