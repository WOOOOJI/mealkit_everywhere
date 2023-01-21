package com.shop.dto;

import lombok.Data;

@Data
public class CategoryDTO {
	private int categoryKey;
	private int categoryKey2;
	private String name;
	private String orderCri;
	private String keyword;
	
	public CategoryDTO(){
		this.categoryKey = 1;
		
	}
}
