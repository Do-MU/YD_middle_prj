package com.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;

public class MemberUpdatePwForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String fid = request.getParameter("fid");
		request.setAttribute("fid", fid);
		
		return "member/memberUpdatePwForm";
	}

}
