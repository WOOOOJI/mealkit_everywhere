package com.shop.dto;

import lombok.Data;

@Data
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
