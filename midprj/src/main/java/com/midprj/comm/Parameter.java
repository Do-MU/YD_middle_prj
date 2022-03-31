package com.midprj.comm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parameter {
	private String key;
	private String value;
	
	public Parameter(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
