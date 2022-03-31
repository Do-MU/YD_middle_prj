package com.midprj.qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.comm.Command;
import com.midprj.qna.service.QnaService;
import com.midprj.qna.service.QnaVO;
import com.midprj.qna.serviceImpl.QnaServiceImpl;

public class QnaView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("loginId");
		QnaService qDAO = new QnaServiceImpl();
		QnaVO vo = new QnaVO();
		
		vo.setQnaId(Integer.parseInt(request.getParameter("qna_id")));
		vo = qDAO.qnaSelect(vo);
		
		
		request.setAttribute("authority",memberId);
		request.setAttribute("q", vo);
		return "qna/qnaView";
	}

}
