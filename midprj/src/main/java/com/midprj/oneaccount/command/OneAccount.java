package com.midprj.oneaccount.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.midprj.comm.Command;
import com.midprj.comm.OpenBank;
import com.midprj.oneaccount.service.OneAccountJson;
import com.midprj.oneaccount.service.OneAccountService;
import com.midprj.oneaccount.service.OneAccountVO;
import com.midprj.oneaccount.serviceImpl.OneAccountServiceImpl;

public class OneAccount implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		HttpSession session = request.getSession();
		String access_token = (String)session.getAttribute("access_token");
		System.out.println(access_token);
		String fintech_use_num = request.getParameter("finNum");
		System.out.println(fintech_use_num);
		
		String result = OpenBank.checkBalance(fintech_use_num, access_token);
		System.out.println(result);
		Gson gson = new Gson();
		OneAccountJson oaj = gson.fromJson(result, OneAccountJson.class);
		
		OneAccountVO vo = new OneAccountVO();

		
		vo.setBank_name(oaj.getBank_name());
		vo.setFintech_use_num(oaj.getFintech_use_num());
		vo.setBalance_amt(oaj.getBalance_amt());
		vo.setProduct_name(oaj.getProduct_name());
		vo.setAccount_issue_date(oaj.getAccount_issue_date());
		vo.setMaturity_date(oaj.getMaturity_date());
		
		System.out.println(vo);
		

		request.setAttribute("bank_name", vo.getBank_name());
		request.setAttribute("finNum", vo.getFintech_use_num());
		request.setAttribute("balance_amt", vo.getBalance_amt());
		request.setAttribute("product_name", vo.getProduct_name());
		request.setAttribute("account_issue_date", vo.getAccount_issue_date());
		request.setAttribute("maturity_date", vo.getMaturity_date());
		
		
		return "oneAccount/showOneAccount";
	}

}
