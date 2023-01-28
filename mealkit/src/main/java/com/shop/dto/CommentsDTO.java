package com.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDTO {
	private int commentsKey;
	private int adminKey;
	private int boardKey;
	private String content;
	private String rdate;
	
}
