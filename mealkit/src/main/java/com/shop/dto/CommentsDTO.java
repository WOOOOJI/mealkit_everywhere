package com.shop.dto;

import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class CommentsDTO {
	private int commentsKey;
	private int adminKey;
	private int boardKey;
	private String content;
	private SimpleDateFormat rdate;
}
