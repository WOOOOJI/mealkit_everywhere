package com.shop.dto;

import lombok.Data;

@Data
public class OrderDTO {
	private int orderKey;
	private int custKey;
	private int price;
	
	private String rdate;
	
	private String status;
	private String name;
	private String zipcode;
	private String addr;
	private String addrDetail;
	private String tel;
	private String req;
	private String refund;
	private String reason;
	private String trackingNum;
	
	//장바구니에서 가져올 변수들
	private String itemImg;
	private String itemName;
	private int itemCnt;
	private int total;
	private int itemPrice;
	private int itemKey;
	private int itemSale;
	
	//item의 재고와 cart의 수를 비교할 변수
	private int cntcheck;
}
