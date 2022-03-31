package com.midprj.comment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.comment.service.CommentService;
import com.midprj.comment.service.CommentVO;
import com.midprj.comment.serviceImpl.CommentServiceImpl;

public class CommentDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CommentService cDAO = new CommentServiceImpl();
		CommentVO vo = new CommentVO();
		
		int cID = Integer.parseInt(request.getParameter("commentId"));
		System.out.println(cID);
		vo.setCommentId(cID);
		
		int n = cDAO.commentDelete(vo);
		System.out.println("댓글 "+ n + "건 삭제");
		
		return "notice/noticeView";
	}

}
