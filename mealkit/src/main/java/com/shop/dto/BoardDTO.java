package com.shop.dto;

import java.text.SimpleDateFormat;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardDTO {
	private int board_key;
	private int cust_key;
	private int item_key;
	private String ntype;
	private String title;
	private SimpleDateFormat rdate;
	private String content;
	private String img;
	private int rate;
	
	private MultipartFile imgfile;
}
