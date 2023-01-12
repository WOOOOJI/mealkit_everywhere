package com.shop.dto;

import lombok.Data;

@Data
public class AdminDTO {
	private int admin_key;
	private String adminid;
	private String adminpwd;
	private String name;
	private int auth;
}
