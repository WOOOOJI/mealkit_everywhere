package com.admin.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
	private int orderDetKey;
	private int orderKey;
	private int itemKey;
	private int price;
	private int cnt;

}
