package com.admin.dto;

import lombok.Data;

@Data
public class AdminDTO {
	private int adminKey;
	private String adminId;
	private String adminPwd;
	private String name;
	private int auth;
}
