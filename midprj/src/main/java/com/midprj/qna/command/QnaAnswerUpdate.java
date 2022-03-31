package com.midprj.qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.qna.service.QnaService;
import com.midprj.qna.service.QnaVO;
import com.midprj.qna.serviceImpl.QnaServiceImpl;

public class QnaAnswerUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		QnaService qnaDao = new QnaServiceImpl();
		QnaVO vo = new QnaVO();

		vo.setQnaId(Integer.parseInt(request.getParameter("qnaId")));
		vo.setQnaAnswerContents(request.getParameter("answer"));
		vo.setQnaIsAnswered(1);
		int n = qnaDao.qnaUpdate(vo);
		
		System.out.println("답변 " + n+ "건 등록");

		if (n != 0) {
			request.setAttribute("message", "문의사항에 대한 답변이 등록되었습니다.");
			return "qna/qnaList";
		}else {
			request.setAttribute("message", "답변등록이 실패하였습니다.");
			return "qna/qnaList";
		}
	}
}
