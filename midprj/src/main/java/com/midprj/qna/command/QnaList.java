package com.midprj.qna.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.comm.Command;
import com.midprj.page.service.PageVO;
import com.midprj.qna.service.QnaService;
import com.midprj.qna.service.QnaVO;
import com.midprj.qna.serviceImpl.QnaServiceImpl;

public class QnaList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		QnaService qDAO = new QnaServiceImpl();
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("loginId");
//		System.out.println("locatin : QnaList.java , session value (memberId :  " + memberId + ")");
//		request.setAttribute("qnaList", qDAO.qnaSelectList(memberId));
		
		
		int pageNum = 1;
		int amount = 10;
		
		if(request.getParameter("pageNum") != null && request.getParameter("amount") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			System.out.println(pageNum);
			amount = Integer.parseInt(request.getParameter("amount"));
			System.out.println(amount);
		}
		
		List<QnaVO> list = qDAO.getList(pageNum, amount, memberId);
		int total = qDAO.getTotal(memberId);
		System.out.println(total);
		PageVO pageVO = new PageVO(pageNum , amount, total);
		
		request.setAttribute("pageVO", pageVO);
		
		request.setAttribute("list", list);
		
		
		return "qna/qnaList";
	}

}