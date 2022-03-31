package com.midprj.accounts.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.accounts.service.AccountsService;
import com.midprj.accounts.service.AccountsVO;
import com.midprj.accounts.serviceImpl.AccountsServiceImpl;
import com.midprj.comm.Command;

public class AccountsView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		AccountsService aDAO = new AccountsServiceImpl();
		AccountsVO aVO = new AccountsVO();
		
		aVO = aDAO.selectOneAccount(request.getParameter("fin_num"));
		
		request.setAttribute("ac", aVO);

		return "accounts/accountsView";
	}

}
