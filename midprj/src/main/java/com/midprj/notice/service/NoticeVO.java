package com.midprj.notice.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter	
public class NoticeVO {
	private int noticeId;
	private String noticeTitle;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date noticeDate;
	private String noticeContents;
	private int noticeHit;
	private int commentQuery;
}
