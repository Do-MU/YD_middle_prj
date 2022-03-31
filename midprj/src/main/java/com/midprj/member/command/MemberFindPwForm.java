package com.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;

public class MemberFindPwForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		return "member/memberFindPwForm";
	}

}
