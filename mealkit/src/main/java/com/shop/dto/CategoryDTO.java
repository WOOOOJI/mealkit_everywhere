package com.shop.dto;

import lombok.Data;

@Data
public class CategoryDTO {
	private int category_key;
	private int category_key2;
	private String name;
	private String orderCri;
	private String keyword;
	
	public CategoryDTO(){
		this.category_key = 1;
		
	}
}
