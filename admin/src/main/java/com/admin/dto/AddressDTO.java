package com.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AddressDTO {
	private int addr_key;
	private int cust_key;
	private String name;
	private String zipcode;
	private String addr;
	private String addr_detail;
	private String tel;
	private String req;
	private String def;
}
