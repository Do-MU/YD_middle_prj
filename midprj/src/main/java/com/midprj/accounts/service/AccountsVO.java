package com.midprj.accounts.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountsVO {
	public AccountsVO() {
		// TODO Auto-generated constructor stub
	}
	private String fintech_use_num;
	private String bank_code_std;
	private String bank_name;
	private String account_num_masked; 
	private String account_holder_name;
	private String account_state;
	private String account_balance;
	private String user_seq_no;

}
