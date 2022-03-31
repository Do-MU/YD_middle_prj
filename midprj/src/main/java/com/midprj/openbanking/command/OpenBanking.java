package com.midprj.openbanking.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;

public class OpenBanking implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "openBanking/openHome";
	}

}
