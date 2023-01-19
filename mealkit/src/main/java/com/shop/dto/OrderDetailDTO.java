package com.shop.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
	private int orderdet_key;
	private int order_key;
	private int item_key;
	private int price;
	private int cnt;
	
	//주문상세의 아이템 이름과 이미지에 필요한 변수
	private String item_name;
	private String item_img;
	
}
