package com.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CustomerDTO {
	private int cust_key;
	private String email;
	private String username;
	private String userpwd;
	private String tel;
	private String banned;
	private String signout;
}
