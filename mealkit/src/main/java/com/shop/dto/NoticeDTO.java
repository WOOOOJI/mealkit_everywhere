package com.shop.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NoticeDTO {
	private int notice_key;
	private int admin_key;
	private String ntype;
	private String title;
	private String write;
	private String img1;
	private String img2;
	private String rdate;
	private int hit;
	
	private MultipartFile imgfile;
}
