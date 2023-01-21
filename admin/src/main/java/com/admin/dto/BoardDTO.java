package com.admin.dto;

import java.text.SimpleDateFormat;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardDTO {
	private int boardKey;
	private int custKey;
	private int itemKey;
	private String ntype;
	private String title;
	private SimpleDateFormat rdate;
	private String content;
	private String img;
	private int rate;
	
	private MultipartFile imgfile;
}
