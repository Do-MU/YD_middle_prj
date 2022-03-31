package com.midprj.oneaccount.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.midprj.comm.Command;
import com.midprj.comm.OpenBank;
import com.midprj.transaction.service.TransactionListJson;
import com.midprj.transaction.service.TransactionService;
import com.midprj.transaction.service.TransactionVO;
import com.midprj.transaction.serviceImpl.TransactionServiceImpl;


public class OneAccount implements Command {
	TransactionService tDAO = new TransactionServiceImpl();
	TransactionVO tVO = new TransactionVO();

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String fin_num = request.getParameter("fin_num");
		HttpSession session = request.getSession();
		
		
		String access_token = (String) session.getAttribute("access_token");
		String tranList = OpenBank.transactionList(fin_num, access_token);
		
		System.out.println(tranList);
		
		Gson gson = new Gson();
		TransactionListJson tlj = gson.fromJson(tranList,TransactionListJson.class);
		
		for(TransactionVO ta : tlj.getRes_list()) {
			System.out.println(ta);
			tDAO.insertTransactions(ta);
		}
		
		List<TransactionVO> list = tDAO.selectTransactions(tVO);
		request.setAttribute("list", list);
		
		
		return "oneAccount/showOneAccount";
	}

}
