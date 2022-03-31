package com.midprj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.notice.service.NoticeService;
import com.midprj.notice.service.NoticeVO;
import com.midprj.notice.serviceImpl.NoticeServiceImpl;

public class NoticeUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		int id = Integer.parseInt(request.getParameter("noticeId"));
		String title = request.getParameter("noticeTitle");
		String content = request.getParameter("noticeContents");
		
		vo.setNoticeId(id);
		vo.setNoticeTitle(title);
		vo.setNoticeContents(content);
		
		
		int n = noticeDao.noticeUpdate(vo);
		System.out.println(n+"건 수정 완료");
	
		if (n!= 0) {
			request.setAttribute("notice", noticeDao.noticeSelect(vo));
			return "notice/noticeView";
		}else {
			request.setAttribute("notice", noticeDao.noticeSelectList());
			return "notice/noticeList";
		}
		
		
		
	}

}
