package com.midprj.qna.command;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.comm.Command;

public class QnaInsertForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("loginId");
		LocalDate now = LocalDate.now();

		request.setAttribute("memberId", memberId);
		request.setAttribute("Date", now );
		
		return "qna/qnaInsertForm";
	}

}