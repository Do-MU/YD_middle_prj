package com.midprj.oneaccount.service;

import lombok.Data;
@Data
public class OneAccountJson {
//	{"api_tran_id":"e7a8ab4b-95c8-44db-b6cd-68f4792261b8",
//		"rsp_code":"A0000",
//		"rsp_message":"",
//		"api_tran_dtm":"20220331111731650",
//		"bank_tran_id":"M202200519U514116268",
//		"bank_tran_date":"20190101",
//		"bank_code_tran":"097",
//		"bank_rsp_code":"000",
//		"bank_rsp_message":"",
//		"fintech_use_num":"120220051988941035890913",
//		"balance_amt":"50000000",
//		"available_amt":"10000000",
//		"account_type":"1",
//		"product_name":"알뜰자유적립",
//		"bank_name":"카카오은행",
//		"savings_bank_name":"",
//		"account_issue_date":"00000000",
//		"maturity_date":"00000000",
//		"last_tran_date":"00000000"}

	
	private String api_tran_id;
	private String rsp_code;
	private String rsp_message;
	private String api_tran_dtm;
	private String bank_tran_id;
	private String bank_tran_date;
	private String bank_rsp_code;
	private String bank_rsp_message;
	private String fintech_use_num;
	private String balance_amt;
	private String available_amt;
	private String account_type;
	private String product_name;
	private String bank_name;
	private String savings_bank_name;
	private String account_issue_date;
	private String maturity_date;
	private String last_tran_date;

	
}
