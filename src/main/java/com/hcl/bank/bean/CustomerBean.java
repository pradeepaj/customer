package com.hcl.bank.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class CustomerBean {
	
	private long id;
	private String name;
	private long phone;
	private String address;
	

}
