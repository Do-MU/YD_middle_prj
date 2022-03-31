package com.midprj.comment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.comment.service.CommentService;
import com.midprj.comment.service.CommentVO;
import com.midprj.comment.serviceImpl.CommentServiceImpl;

public class CommentUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CommentService cDAO = new CommentServiceImpl();
		CommentVO vo = new CommentVO();
		
		vo.setCommentId(Integer.parseInt(request.getParameter("commentId")));
		vo.setCommentContents(request.getParameter("commentContents"));
		int n = cDAO.commentUpdate(vo);

		System.out.println("댓글 "+ n + "건 수정");
		
		return "notice/noticeView";
	}

}
