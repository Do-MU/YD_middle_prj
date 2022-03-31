package com.midprj.qna.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface QnaMapper {
	List<QnaVO> qnaSelectList(String memberId);
	
	QnaVO qnaSelect(QnaVO vo);
	int qnaInsert(QnaVO vo);
	int qnaUpdate(QnaVO vo);
	Integer getTotal();
	
	List<QnaVO> getList(@Param("pageNum")int pageNum,@Param("amount") int amount,@Param("memberId") String memberId);
}
