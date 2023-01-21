package com.shop.dto;

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
	
	// 추가적인 데이터를 저장하기 위한 변수
	private String name;
	private int price;
	private int sale;
	private int total;
	private int cartcnt;
}
