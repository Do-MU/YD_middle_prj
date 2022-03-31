package com.midprj.accounts.command;

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

public class accountsList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		AccountsService aDAO = new AccountsServiceImpl();
		
		HttpSession session = request.getSession();
		String access_token = (String) session.getAttribute("access_token");
		String user_seq_no = (String) session.getAttribute("user_seq_no");
		
		String result = OpenBank.getAccountList(user_seq_no, access_token);
		System.out.println(result);
		
		
		Gson gson = new Gson();
		AccountsListJson alj = gson.fromJson(result, AccountsListJson.class);
		//System.out.println(alj.getRes_list());
		
		for(AccountsVO ac : alj.getRes_list()) {
			System.out.println(ac);
			if(aDAO.selectAccountInfo(ac)==0) {
				System.out.println(aDAO.selectAccountInfo(ac));
				aDAO.insertAccounts(ac);
			}
				
			
		}
		List<AccountsVO> list = alj.getRes_list();
		request.setAttribute("list", list);
		
		/*
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObject =(JSONObject)parser.parse(result);
			JSONArray jsonArray = (JSONArray)jsonObject.get("res_list");
			
			for(int i=0; i < jsonArray.size(); i++) {
				JSONObject jObject = (JSONObject) jsonArray.get(i);
			}
			
			session.setAttribute("accountList", result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		return "accounts/accountsList";
	}

}