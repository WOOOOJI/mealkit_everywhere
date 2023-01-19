package com.admin.dto;

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

}
