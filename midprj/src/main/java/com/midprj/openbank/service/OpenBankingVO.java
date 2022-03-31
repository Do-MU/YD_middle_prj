package com.midprj.openbank.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenBankingVO {

	private String code;
	private String access_token;
	private String refresh_token;
	private String user_seq_no ;
	private String member_id;

	
}
