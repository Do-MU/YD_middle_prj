package com.midprj.oneaccount.service;

import lombok.Data;

@Data
public class OneAccountVO {
	private String bank_name;
	private String fintech_use_num;
	private String balance_amt;
	private String product_name;
	private String account_issue_date;
	private String maturity_date;
	
}
