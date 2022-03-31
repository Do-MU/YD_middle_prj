package com.midprj.openbanking.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.midprj.comm.Command;
import com.midprj.comm.OpenBank;
import com.midprj.openbank.service.OpenBankingService;
import com.midprj.openbank.service.OpenBankingVO;
import com.midprj.openbank.serviceImpl.OpenBankingServiceImpl;

import net.sf.json.JSONObject;

public class CallbackCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		OpenBankingService openDao = new OpenBankingServiceImpl();
		
		
		OpenBankingVO vo = new OpenBankingVO();
		vo.setCode(code);
		
		HttpSession session = request.getSession();
		if(vo != null) {
			session.setAttribute("code", vo.getCode());
			
		}
		
		//access_token 발급받기
		String result = OpenBank.getAccessToken(code);
		JSONObject obj = JSONObject.fromObject(result);
		String access_token = obj.getString("access_token");
		String refresh_token = obj.getString("refresh_token");
		String user_seq_no = obj.getString("user_seq_no");
		String member_id = (String) session.getAttribute("loginId");
		
		vo.setAccess_token(access_token);
		vo.setRefresh_token(refresh_token);
		vo.setUser_seq_no(user_seq_no);
		vo.setMember_id(member_id);
		
		
		
		session.setAttribute("access_token", vo.getAccess_token());
		session.setAttribute("user_seq_no", user_seq_no);
		System.out.println(vo.getAccess_token());
		
		int n = openDao.insertMember(vo);
		if(n != 0) {
			request.setAttribute("message", "DB등록완료");
			return "openBanking/openHome";
		}else {
			request.setAttribute("message", "DB등록 실패");
			return "openBanking/openHome";
		}
		
	}

}
