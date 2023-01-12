package com.shop.dto;

import lombok.Data;

@Data
public class CustomerDTO {
	private int cust_key;
	private String email;
	private String username;
	private String userpwd;
	private String tel;
	private String banned;
	private String signout;
}
