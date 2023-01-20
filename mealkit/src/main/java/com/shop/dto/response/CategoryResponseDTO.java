package com.shop.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.shop.dto.CategoryDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class CategoryResponseDTO {

	private List<CategoryDTO> categoryList = new ArrayList<>();
	
	
}
