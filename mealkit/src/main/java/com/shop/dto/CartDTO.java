package com.shop.dto;

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
	
	// 추가적인 데이터를 저장하기 위한 변수
	private String name;
	private int price;
	private int sale;
	private int total;
	private int cartcnt;
}
