package com.midprj.accounts.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountsListJson {
	private String api_tran_id;
	private String api_tran_dtm;
	private String rsp_code;
	private String rsp_message;
	private String user_name;
	private String res_cnt;
	private List<AccountsVO> res_list;
}
