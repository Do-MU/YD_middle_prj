package com.midprj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.notice.service.NoticeService;
import com.midprj.notice.service.NoticeVO;
import com.midprj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeUpdateForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService nDAO = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();

		vo.setNoticeId(Integer.parseInt(request.getParameter("noticeId")));
		
		request.setAttribute("n", nDAO.noticeSelect(vo));
		request.setAttribute("message", "update");
		
		return "notice/noticeInsertForm";
	}

}
