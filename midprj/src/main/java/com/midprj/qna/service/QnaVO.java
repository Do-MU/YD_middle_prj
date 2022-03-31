package com.midprj.qna.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QnaVO {
	private int qnaId;
	private String qnaTitle;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date qnaDate;
	private String qnaContents;
	private String memberId;
	private int qnaIsAnswered;
	private String qnaAnswerContents;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date qnaAnswerDate;
}
