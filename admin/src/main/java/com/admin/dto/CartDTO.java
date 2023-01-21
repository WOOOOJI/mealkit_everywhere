package com.admin.dto;

import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class CartDTO {
	// DB와 일치 하는 변수
	private int cartKey;
	private int custKey;
	private int itemKey;
	private int cnt;
	private SimpleDateFormat rdate;

}
