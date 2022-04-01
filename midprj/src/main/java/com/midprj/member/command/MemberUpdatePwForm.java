package com.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.midprj.comm.Command;

public class MemberUpdatePwForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String fid = request.getParameter("fid");
		if(fid != null) {
			request.setAttribute("fid", fid);			
		}
		else {
			request.setAttribute("fid", session.getAttribute("loginId"));
		}
		
		
		return "member/memberUpdatePwForm";
	}

}
