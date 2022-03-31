package com.midprj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.notice.service.NoticeService;
import com.midprj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDao = new NoticeServiceImpl();
		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		
		int n = noticeDao.noticeDelete(noticeId);
		System.out.println(n+ "건 삭제 완료");
		if(n != 0) {
			request.setAttribute("notice", noticeDao.noticeSelectList());
			request.setAttribute("message", "삭제되었습니다.");
			return"notice/noticeList";
		}else {
			request.setAttribute("message", "삭제가 실패하였습니다.");
			return "notice/noticeList";
		}
	}

}
