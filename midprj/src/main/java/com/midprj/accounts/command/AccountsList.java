package com.midprj.accounts.command;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.midprj.accounts.service.AccountsListJson;
import com.midprj.accounts.service.AccountsService;
import com.midprj.accounts.service.AccountsVO;
import com.midprj.accounts.serviceImpl.AccountsServiceImpl;
import com.midprj.comm.Command;
import com.midprj.comm.OpenBank;
import com.midprj.oneaccount.service.OneAccountJson;
import com.midprj.transaction.service.TransactionListJson;

public class AccountsList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		AccountsService aDAO = new AccountsServiceImpl();
		AccountsVO aVO = new AccountsVO();
		
		HttpSession session = request.getSession();
		String access_token = (String) session.getAttribute("access_token");
		String user_seq_no = (String) session.getAttribute("user_seq_no");
		
		String accList = OpenBank.getAccountList(user_seq_no, access_token);
//		System.out.println(result);
		
		
		Gson gson = new Gson();
		AccountsListJson alj = gson.fromJson(accList, AccountsListJson.class);
//		System.out.println(alj.getRes_list());
		
		// 프로그램이 실행될때마다 테스트베드에서 목록을 가져와서 새로 추가된 계좌목록이 있는지 확인
		for(AccountsVO ac : alj.getRes_list()) {
//			System.out.println(ac);
			
			// 핀테크이용번호(계좌당 하나)와 엑세스토큰을 통해 해당 계좌의 잔액을 조회
			// >> oaj에 저장
			String balanceInfo = OpenBank.checkBalance(ac.getFintech_use_num(), access_token);
			System.out.println("balanceInfo: " + balanceInfo);
			OneAccountJson oaj = gson.fromJson(balanceInfo, OneAccountJson.class);
			oaj.setBalance_amt(changeNumFormat(oaj.getBalance_amt()));
			
			// 불러온 계좌list 중 DB에 저장되지 않은 계좌list가 있다면 등록
			if(aDAO.selectAccountInfo(ac)==0) {
				System.out.println("INSERT!!!!");
				
				ac.setUser_seq_no(user_seq_no);				// 사용자 일련번호 추가
				ac.setProduct_name(oaj.getProduct_name());	// 계좌명 (잔액조회)
				ac.setBalance_amt(oaj.getBalance_amt());	// 계좌잔액 (잔액조회)
				aDAO.insertAccounts(ac);
			}
			
//			System.out.println(ac.getFintech_use_num());
			
			// 잔액조회를 통해 불러온 잔액과 DB상의 데이터의 잔액이 다르다면
			// 해당 계좌에 대한 잔액조회 결과를 불러와서 DB에 저장
			if(aDAO.selectOneAccount(ac.getFintech_use_num()).getBalance_amt() != oaj.getBalance_amt()) {
				System.out.println("UPDATE!!!!");

				ac.setProduct_name(oaj.getProduct_name());
				ac.setBalance_amt(oaj.getBalance_amt());
				aDAO.updateAccounts(ac);					// 상품명과 계좌 잔액만을 수정
			}
		}
		
		aVO.setUser_seq_no(user_seq_no);					// 사용자 일련번호
		List<AccountsVO> list = aDAO.selectAccounts(aVO);	// 사용자 일련번호가 같은 데이터들
		request.setAttribute("list", list);
		
		return "accounts/accountsList";
	}
	
	String changeNumFormat(String numStr) {
		DecimalFormat decFormat = new DecimalFormat("###,###");

		return decFormat.format(Integer.parseInt(numStr));
	}

}