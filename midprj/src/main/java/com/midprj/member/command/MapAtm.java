package com.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.comm.Command;
import com.midprj.member.service.MemberService;
import com.midprj.member.service.MemberVO;
import com.midprj.member.serviceImpl.MemberServiceImpl;

public class MapAtm implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginId");
		
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		if(id != null) {
			
			vo.setMemberId(id);
			vo = memberDao.selectMember(vo);
			request.setAttribute("id", vo.getMemberId());
			request.setAttribute("memberAddress", vo.getMemberAddress());
			return "mypage/mapAtm";
		}else {
			return "member/mapAtm";
		}
		
	}
	
}
