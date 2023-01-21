package com.shop.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
	private int orderDetKey;
	private int orderKey;
	private int itemKey;
	private int price;
	private int cnt;
	
	//주문상세의 아이템 이름과 이미지에 필요한 변수
	private String itemName;
	private String itemImg;
	
}
