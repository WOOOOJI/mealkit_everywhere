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
	private String reason;
	private String trackingNum;
	private int itemCnt;
	private String itemName;
	private String itemImg;
	
	//추가 변수
	private String custName;
	private String refund;

	
	
	// 년,월,일의 매출차트에 필요한 변수 (날짜 지정)
	private String tempDate;
	private int totalSales;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//기간별 TOP10, BOT10, 매출데이터를 위한 변수
	private int totCnt;
	private int totPrice;
	private int mthly;
	private int daily;
	private int timly;
}
