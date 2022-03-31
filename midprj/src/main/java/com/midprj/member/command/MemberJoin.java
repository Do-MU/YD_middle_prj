package com.midprj.member.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.comm.Command;
import com.midprj.member.service.MemberService;
import com.midprj.member.service.MemberVO;
import com.midprj.member.serviceImpl.MemberServiceImpl;

public class MemberJoin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String address = request.getParameter("addr1") + " " + request.getParameter("addr2");
		
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id"));
		vo.setMemberPw(request.getParameter("password"));
		vo.setMemberName(request.getParameter("name"));
		vo.setMemberEmail(request.getParameter("email"));
		vo.setMemberTel(request.getParameter("tel"));
		vo.setMemberBirth(request.getParameter("birth"));
		vo.setMemberAddress(address);

		int n = memberDao.insertMember(vo);
		if (n != 0) {
			request.setAttribute("message", "회원가입완료");
			request.setAttribute("id", vo.getMemberId());
			return "member/memberLoginForm";
		} else {
			request.setAttribute("message", "회원가입실패");
			return "member/memberJoinForm";
		}
		
	}

}
