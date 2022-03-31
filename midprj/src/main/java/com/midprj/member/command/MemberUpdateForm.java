package com.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.comm.Command;
import com.midprj.member.service.MemberService;
import com.midprj.member.service.MemberVO;
import com.midprj.member.serviceImpl.MemberServiceImpl;

public class MemberUpdateForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginId");
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(id);
		vo = memberDao.selectMember(vo);

		request.setAttribute("memberId", vo.getMemberId());
		request.setAttribute("memberPw", vo.getMemberPw());
		request.setAttribute("memberName", vo.getMemberName());
		request.setAttribute("memberEmail", vo.getMemberEmail());
		request.setAttribute("memberTel", vo.getMemberTel());
		request.setAttribute("memberBirth", vo.getMemberBirth());
		request.setAttribute("memberAddress", vo.getMemberAddress());

		return "mypage/memberUpdateForm";
	}

}
