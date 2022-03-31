package com.midprj.openbanking.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.comm.Command;
import com.midprj.member.service.MemberService;
import com.midprj.member.service.MemberVO;
import com.midprj.member.serviceImpl.MemberServiceImpl;
import com.midprj.openbank.service.OpenBankingService;
import com.midprj.openbank.service.OpenBankingVO;
import com.midprj.openbank.serviceImpl.OpenBankingServiceImpl;

public class OpenBanking implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberService mDAO = new MemberServiceImpl();
		OpenBankingService oDAO = new OpenBankingServiceImpl();
		MemberVO mVO  = new MemberVO();
		OpenBankingVO oVO = new OpenBankingVO();
		
		HttpSession session = request.getSession();
		
		String loginId = (String) session.getAttribute("loginId"); 
		mVO.setMemberId(loginId);
		mVO = mDAO.selectMember(mVO);
		if(loginId!=null) {
			if(mVO.getUserSeqNo() != null) {
				System.out.println("조회 이력이 있음");
				oVO.setMember_id(loginId);
//				System.out.println(oVO.getMember_id());
				oVO = oDAO.selectMember(oVO);
				
				session.setAttribute("access_token", oVO.getAccess_token());
				session.setAttribute("user_seq_no", oVO.getUser_seq_no());
			}
		}
		
		
		return "openBanking/openHome";
	}

}