package com.midprj.notice.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.midprj.comm.Command;
import com.midprj.notice.service.NoticeService;
import com.midprj.notice.service.NoticeVO;
import com.midprj.notice.serviceImpl.NoticeServiceImpl;


public class AjaxNoticeSearch implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService NoticeDao = new NoticeServiceImpl();
		
		String key = request.getParameter("key");
		String val = request.getParameter("val");
		List<NoticeVO> list = NoticeDao.noticeSelectSearchList(key, val);
		String data = null;
		try {
			data = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "ajax:" + data;
	}
}
