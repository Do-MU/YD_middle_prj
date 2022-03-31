package com.midprj.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;

public class NoticeInsertForm implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("message", "insert");
		
		return "notice/noticeInsertForm";
	}
}
