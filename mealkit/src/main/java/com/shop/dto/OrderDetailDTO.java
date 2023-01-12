package com.shop.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
	private int orderdet_key;
	private int order_key;
	private int item_key;
	private int price;
	private int cnt;
	
}
