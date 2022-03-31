package com.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.comm.Command;
import com.midprj.member.service.MemberService;
import com.midprj.member.service.MemberVO;
import com.midprj.member.serviceImpl.MemberServiceImpl;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 처리 과정
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id"));
		vo.setMemberPw(request.getParameter("password"));

		vo = memberDao.selectMember(vo);
		HttpSession session = request.getSession();
		
		if(vo != null) {
			//여기서 세션 처리하고
			session.setAttribute("loginId", vo.getMemberId());
			session.setAttribute("loginName", vo.getMemberName());
			session.setAttribute("loginEmail", vo.getMemberEmail());			
			session.setAttribute("loginTime", 900);
			request.setAttribute("message", vo.getMemberName() + " 님 환영합니다.");
			return "home/home";
		}else {
			request.setAttribute("message", "아이디 또는 패스워드가 틀립니다.");
			return "member/memberLoginForm";
		}
		
	}

}
