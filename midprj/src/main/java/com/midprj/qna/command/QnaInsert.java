package com.midprj.qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.qna.service.QnaService;
import com.midprj.qna.service.QnaVO;
import com.midprj.qna.serviceImpl.QnaServiceImpl;

public class QnaInsert implements Command{
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		QnaService qnaDao = new QnaServiceImpl();
		QnaVO vo = new QnaVO();
		
		vo.setQnaTitle(request.getParameter("qnaTitle"));
		vo.setQnaContents(request.getParameter("qnaContents"));
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberId(request.getParameter("memberId"));
		int n = qnaDao.qnaInsert(vo);
		
		System.out.println("문의사항 " + n+ "건 등록");
		
		if (n != 0) {
			request.setAttribute("message", "문의사항이 등록되었습니다.");
			return "qna/qnaList";
		}else {
			request.setAttribute("message", "문의사항등록이 실패하였습니다.");
			return "qna/qnaList";
		}
	}
}