package com.midprj.comment.command;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.comment.service.CommentService;
import com.midprj.comment.service.CommentVO;
import com.midprj.comment.serviceImpl.CommentServiceImpl;

public class CommentInsert implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CommentService commentDao = new CommentServiceImpl();
		SimpleDateFormat form = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		
		CommentVO vo = new CommentVO();
		vo.setCommentContents(request.getParameter("commentContent"));
		vo.setMemberId(request.getParameter("memberId"));
		vo.setNoticeId(Integer.parseInt(request.getParameter("noticeId")));
		vo.setCommentDate(form.format(System.currentTimeMillis()));
		
		int n = commentDao.commentInsert(vo);
		System.out.println("댓글" + n + "건 등록");
		
		return "notice/noticeView";
	}
}
