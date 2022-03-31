package com.midprj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.midprj.comm.Command;
import com.midprj.member.service.MemberService;
import com.midprj.member.service.MemberVO;
import com.midprj.member.serviceImpl.MemberServiceImpl;

public class MemberUpdate implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String fName = request.getParameter("fName");
		String fid = request.getParameter("fId");
		String password = request.getParameter("password");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		if(address == "") {
			address = request.getParameter("addr1") + " "+request.getParameter("addr2");
		}
		String email = request.getParameter("email");
		
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberName(fName);
		vo.setMemberId(fid);
		vo.setMemberPw(password);
		vo.setMemberTel(tel);
		vo.setMemberAddress(address);
		vo.setMemberEmail(email);
		memberDao.updateMember(vo);
		
		
		return "mypage/memberMyPage";
	}

}
