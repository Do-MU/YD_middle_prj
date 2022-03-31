package com.midprj.transaction.service;

import java.util.List;

import lombok.Data;

@Data
public class TransactionListJson {
//	{
//	    "api_tran_id": "5e5ba78b-0419-4636-b7dd-b5dc2f94c46e",
//	    "rsp_code": "A0000",
//	    "rsp_message": "",
//	    "api_tran_dtm": "20220331160059735",
//	    "bank_tran_id": "M202200519U987654323",
//	    "bank_tran_date": "20190101",
//	    "bank_code_tran": "097",
//	    "bank_rsp_code": "000",
//	    "bank_rsp_message": "",
//	    "fintech_use_num": "120220051988941035890913",
//	    "balance_amt": "50000000",
//	    "page_record_cnt": "25",
//	    "next_page_yn": "Y",
//	    "befor_inquiry_trace_info": "",
//	    "bank_name": "카카오은행",
//	    "savings_bank_name": "",
//	    "res_list"[]
//	}

	private String api_tran_id;
	private String rsp_code;
	private String rsp_message;
	private String api_tran_dtm;
	private String bank_tran_id;
	private String bank_tran_date;
	private String bank_code_tran;
	private String bank_rsp_code;
	private String bank_rsp_message;
	private String fintech_use_num;
	private String balance_amt;
	private String page_record_cnt;
	private String next_page_yn;
	private String befor_inquiry_trace_info;
	private String bank_name;
	private String savings_bank_name;
	private List<TransactionVO> res_list;
	
	
	

}
