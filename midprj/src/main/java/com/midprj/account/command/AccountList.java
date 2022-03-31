package com.midprj.account.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.account.service.AccountService;
import com.midprj.account.service.AccountVO;
import com.midprj.account.service.SumAccMemVO;
import com.midprj.account.serviceImpl.AccountServiceImpl;
import com.midprj.comm.Command;

public class AccountList implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String loginId =  (String)session.getAttribute("loginId");
		System.out.println("location : 계좌조회 | 세션(현재 로그인된 id :"+ loginId+")");
		
		AccountService accountDao = new AccountServiceImpl();
		//로그인한 id의 계좌조회
		List<SumAccMemVO> list = accountDao.accountSelectList(loginId);
		request.setAttribute("account", list);
		return "account/accountList";
	}
	
	
}
