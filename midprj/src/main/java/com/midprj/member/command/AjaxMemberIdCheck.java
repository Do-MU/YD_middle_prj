package com.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.member.service.MemberService;
import com.midprj.member.service.MemberVO;
import com.midprj.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// aJax로 아이디 중복체크
		MemberService memberDao = new MemberServiceImpl();
		String str = request.getParameter("str");
		MemberVO vo = new MemberVO();
		vo.setMemberEmail(str);
		boolean b;
		String result;
		
		if(str.contains("@")) {
			
			vo = memberDao.selectMemberId(vo);
			if(vo != null) {
				result = "ajax:1" + "|" + vo.getMemberEmail() + "|" + vo.getMemberName() + "|" +  vo.getMemberId();
			}else {
				result = "ajax:0";
			}
			
			return result;
		}else {
			 b = memberDao.isIdCheck(str);
			 if (!b) {
					result = "ajax:0"; // 사용가능한 아이디
				} else {
					result = "ajax:1"; // 이미존재하는 아이디
				}
			 return result;	
		}
		
		
		

	}

}
