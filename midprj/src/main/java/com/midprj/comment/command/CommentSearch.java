package com.midprj.comment.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.comment.service.CommentService;
import com.midprj.comment.service.CommentVO;
import com.midprj.comment.serviceImpl.CommentServiceImpl;

public class CommentSearch implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		List<CommentVO> comments = null;
		CommentService commentDao = new CommentServiceImpl();
		comments = commentDao.commentSelectList(noticeId); 
		System.out.println("commentSearch : " + noticeId);
		System.out.println("comment : " + comments);
		request.setAttribute("comment",comments);
		return "notice/noticeView";
	}
}
