package com.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.member.service.MemberService;
import com.midprj.member.service.MemberVO;
import com.midprj.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberPwUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// aJax로 아이디 중복체크
		MemberService memberDao = new MemberServiceImpl();
		String mId = request.getParameter("mId");
		String mPassword = request.getParameter("mPassword");
		String result;
		MemberVO vo = new MemberVO();
		vo.setMemberId(mId);
		vo.setMemberPw(mPassword);
		int n  = memberDao.updateMember(vo);
		if (n != 0) {
			result = "ajax:1" + "|";
		} else {
			result = "ajax:0" + "|";
		}
		return result;
	}
}

