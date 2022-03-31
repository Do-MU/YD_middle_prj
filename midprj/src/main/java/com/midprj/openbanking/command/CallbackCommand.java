package com.midprj.openbanking.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.comm.Command;
import com.midprj.comm.OpenBank;
import com.midprj.member.service.MemberService;
import com.midprj.member.service.MemberVO;
import com.midprj.member.serviceImpl.MemberServiceImpl;
import com.midprj.openbank.service.OpenBankingService;
import com.midprj.openbank.service.OpenBankingVO;
import com.midprj.openbank.serviceImpl.OpenBankingServiceImpl;

import net.sf.json.JSONObject;


public class CallbackCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		OpenBankingService openDao = new OpenBankingServiceImpl();
		OpenBankingVO oVO = new OpenBankingVO();
		MemberService mDAO = new MemberServiceImpl();
		MemberVO mVO = new MemberVO();
		oVO.setCode(code);
		
		HttpSession session = request.getSession();
		if(oVO != null) {		// code가 없을 시 >> 반환 실패
			session.setAttribute("code", oVO.getCode());
		}
		
		//access_token 발급받기
		String result = OpenBank.getAccessToken(code);
		JSONObject obj = JSONObject.fromObject(result);
		String access_token = obj.getString("access_token");
		String refresh_token = obj.getString("refresh_token");
		String user_seq_no = obj.getString("user_seq_no");
		String member_id = (String) session.getAttribute("loginId");
		
		// vo에 저장
		oVO.setAccess_token(access_token);
		oVO.setRefresh_token(refresh_token);
		oVO.setUser_seq_no(user_seq_no);
		oVO.setMember_id(member_id);
		
		mVO.setMemberId(member_id);
		mVO.setUserSeqNo(user_seq_no);
		int m = mDAO.updateMember(mVO);
		if(m != 0) {
			System.out.println(mVO.getMemberId()+" 업데이트 완료");
		}
		
		session.setAttribute("access_token", oVO.getAccess_token());
		session.setAttribute("user_seq_no", user_seq_no);
		System.out.println(oVO.getAccess_token());
		
		int n = openDao.insertMember(oVO);
		if(n != 0) {
			request.setAttribute("message", "DB등록완료");
			return "openBanking/openHome";
		}else {
			request.setAttribute("message", "DB등록 실패");
			return "openBanking/openHome";
		}
		
	}

}