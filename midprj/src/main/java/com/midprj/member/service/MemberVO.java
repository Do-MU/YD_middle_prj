package com.midprj.member.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberTel;
	//@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private String memberBirth;
	private String memberAddress;
	
	
}
