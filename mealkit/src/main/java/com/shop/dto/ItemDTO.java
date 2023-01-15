package com.shop.dto;

import java.text.SimpleDateFormat;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ItemDTO {
	private int item_key;
	private int category_key;
	private String name;
	
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String img5;
	
	private String content;
	private int price;
	private int sale;
	private int cnt;
	
	
	
	private SimpleDateFormat rdate;
	
	
	private MultipartFile imgfile1;
	private MultipartFile imgfile2;
	private MultipartFile imgfile3;
	private MultipartFile imgfile4;
	private MultipartFile imgfile5;
	
	
	// 퍼센티지 변수 추가
	private int per;
}
