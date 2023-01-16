package com.shop.dto;

import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class OrderDTO {
	private int order_key;
	private int cust_key;
	private int price;
	
	private String rdate;
	
	private String status;
	private String name;
	private String zipcode;
	private String addr;
	private String addr_detail;
	private String tel;
	private String req;
	
	//장바구니에서 가져올 변수들
	private String item_img;
	private String item_name;
	private int item_cnt;
	private int total;
	private int item_price;
	private int item_key;
	private int item_sale;
	
	//item의 재고와 cart의 수를 비교할 변수
	private int cntcheck;
}
