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


public class AjaxSortNotice implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService NoticeDao = new NoticeServiceImpl();
		String key = request.getParameter("key");
		List<NoticeVO> list = NoticeDao.noticeSortList(key);
		String data = null;
		try {
			data = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ajax:"+ data;
	}

}
