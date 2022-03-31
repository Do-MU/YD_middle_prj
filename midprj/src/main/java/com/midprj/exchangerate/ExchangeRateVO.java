package com.midprj.exchangerate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExchangeRateVO {
	private String nation; //국가
	private String currency; //통화
	private String exchangeRate; //환율
	
}
