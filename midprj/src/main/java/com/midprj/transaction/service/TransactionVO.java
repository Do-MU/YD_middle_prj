package com.midprj.transaction.service;

import lombok.Data;

@Data
public class TransactionVO {

//    {
//        "tran_date": "20220301",
//        "tran_time": "010101",
//        "inout_type": "입금",
//        "tran_type": "급여",
//        "print_content": "일급",
//        "tran_amt": "50000000",
//        "after_balance_amt": "50000000",
//        "branch_name": "분당점"
//    }
	
	private String tran_date;
	private String inout_type;
	private String tran_type;
	private String print_content;
	private String tran_amt;
	private String after_balance_amt;
	private String branch_name;
}
