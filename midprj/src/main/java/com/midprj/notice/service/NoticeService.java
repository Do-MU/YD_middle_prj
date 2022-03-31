package com.midprj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(int id);
	int noticeUpdateHit(int id);
	
	Integer getTotal();
	List<NoticeVO> getList(@Param("pageNum")int pageNum,@Param("amount") int amount);
	
	List<NoticeVO> noticeSelectSearchList(String key, String val);
	List<NoticeVO> noticeSortList(String key);
}
