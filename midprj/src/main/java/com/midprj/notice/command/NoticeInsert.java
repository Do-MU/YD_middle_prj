package com.midprj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.notice.service.NoticeService;
import com.midprj.notice.service.NoticeVO;
import com.midprj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeTitle(request.getParameter("noticeTitle"));
		vo.setNoticeContents(request.getParameter("noticeContents"));
		
		int n = noticeDao.noticeInsert(vo);
		
		if (n != 0) {
			request.setAttribute("message", "공지 글 등록이 성공하였습니다.");
			return "notice/noticeList";
		}else {
			request.setAttribute("message", "공지 글 등록이 실패하였습니다.");
			return "notice/noticeList";
		}
		
	}
}
