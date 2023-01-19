package com.shop.dto;

import lombok.Data;

@Data
public class WishDTO {
	private int wish_key;
	private int cust_key;
	private int item_key;
	
	// 추가적인 데이터를 저장하기 위한 변수
	private String name;
	private int price;
	private int sale;
}
