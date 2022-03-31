package com.midprj.openbanking.command;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.AgencyInfo;
import com.midprj.comm.Command;



public class BankOauthCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
		final String url = "https://testapi.openbanking.or.kr/oauth/2.0/authorize"; 
		final String response_type ="code";
		
		//이용기관 정보를 받아온다.
		//request URI 구성요소를 받아온다.			
		String client_id = AgencyInfo.client_id;
		String redirect_uri = AgencyInfo.redirect_uri;
		String scope = AgencyInfo.scope;
		String auth_type = AgencyInfo.auth_type;
		
		System.out.println(client_id+redirect_uri+scope+auth_type);
		
		
		//32자리 난수를 발생시킨다.
		String state = "01234567890123456789012345678912";
		
		
		//request URI를 구성한다.
		StringBuilder uri = new StringBuilder();
		uri.append("response_type="+response_type)
		   .append("&client_id="+client_id)
		   .append("&redirect_uri="+redirect_uri)
		   .append("&scope="+scope)
		   .append("&state="+state)
		   .append("&auth_type="+auth_type);
		
		//reque st를 보낸다.
			response.sendRedirect(url+"?"+uri.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
