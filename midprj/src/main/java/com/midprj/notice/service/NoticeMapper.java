package com.midprj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(int id);
	int noticeUpdateHit(int id);
	int commentQuery(List<NoticeVO> list);
	
	Integer getTotal();
	List<NoticeVO> getList(@Param("pageNum")int pageNum,@Param("amount") int amount);
	
	List<NoticeVO> noticeSelectSearchList(@Param("key")String key,@Param("val") String val);
	List<NoticeVO> noticeSortList(String key);
}
