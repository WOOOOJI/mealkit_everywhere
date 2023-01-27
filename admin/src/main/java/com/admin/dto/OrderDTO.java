package com.admin.dto;

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

	
	//추가 변수
	private String custName;
}
