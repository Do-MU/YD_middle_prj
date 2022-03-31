package com.midprj.account.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AccountVO {

	private long accId;
	private int accPw;
	private int accBalance;
	private String finproId;
	private String memberId;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date accDate;
	private String accBank;
	
}
