package com.shop.dto;

import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class CommentsDTO {
	private int comments_key;
	private int admin_key;
	private int board_key;
	private String content;
	private SimpleDateFormat rdate;
}
