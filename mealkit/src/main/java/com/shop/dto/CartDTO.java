package com.shop.dto;

import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class CartDTO {
	private int cart_key;
	private int cust_key;
	private int item_key;
	private int cnt;
	private SimpleDateFormat rdate;
	
	
	private String name;
	private int price;
	private int sale;
	private int total;
		
}
