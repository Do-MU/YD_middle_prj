package com.midprj.accounts.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.midprj.accounts.service.AccountsService;
import com.midprj.accounts.service.AccountsVO;
import com.midprj.accounts.serviceImpl.AccountsServiceImpl;
import com.midprj.comm.Command;
import com.midprj.comm.OpenBank;
import com.midprj.transaction.service.TransactionListJson;
import com.midprj.transaction.service.TransactionVO;

public class AccountsView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		AccountsService aDAO = new AccountsServiceImpl();
		AccountsVO aVO = new AccountsVO();
		HttpSession session = request.getSession();
		
		String fin_num = request.getParameter("fin_num");
		
		aVO = aDAO.selectOneAccount(fin_num);
		request.setAttribute("ac", aVO);

		// 핀테크이용번호(계좌당 하나)와 엑세스토큰을 통해 해당 계좌의 거래내역을 조회
		// >> tlj에 저장
		String access_token = (String) session.getAttribute("access_token");
		String tranList = OpenBank.transactionList(fin_num, access_token);

		Gson gson = new Gson();
		TransactionListJson tlj = gson.fromJson(tranList, TransactionListJson.class);
		System.out.println("tranList: " + tranList);
		
		List<TransactionVO> list = tlj.getRes_list();
		request.setAttribute("list", list);

		return "accounts/accountsView";
	}

}
