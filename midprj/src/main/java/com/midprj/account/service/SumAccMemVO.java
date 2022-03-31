package com.midprj.account.service;

import com.midprj.member.service.MemberVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumAccMemVO {
	private AccountVO account;
	private MemberVO member;
}
