package com.admin.dto;

import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class CartDTO {
	// DB와 일치 하는 변수
	private int cart_key;
	private int cust_key;
	private int item_key;
	private int cnt;
	private SimpleDateFormat rdate;

}
