package com.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.comm.Command;

public class MemberLoginForm implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.getAttribute("loginName");

		if(session != null) {
			session.invalidate();
		}
		return "member/memberLoginForm";
	}

}
