package com.midprj.notice.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.notice.service.NoticeService;
import com.midprj.notice.service.NoticeVO;
import com.midprj.notice.serviceImpl.NoticeServiceImpl;
import com.midprj.page.service.PageVO;


public class NoticeList implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService noticeDao = new NoticeServiceImpl();
		int pageNum = 1;
		int amount = 10;
		
		if(request.getParameter("pageNum") != null && request.getParameter("amount") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			System.out.println(pageNum);
			amount = Integer.parseInt(request.getParameter("amount"));
			System.out.println(amount);
		}
		List<NoticeVO> list = noticeDao.getList(pageNum, amount);
		int total = noticeDao.getTotal();
		
		PageVO pageVO = new PageVO(pageNum , amount, total);
		
		request.setAttribute("pageVO", pageVO);
		
		request.setAttribute("list", list);
		
//		request.setAttribute("notice", noticeDao.noticeSelectList());
		return "notice/noticeList";
	}
}
