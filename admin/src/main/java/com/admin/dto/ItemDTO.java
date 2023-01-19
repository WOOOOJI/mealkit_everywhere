package com.admin.dto;

import java.text.SimpleDateFormat;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {
	private int item_key;		//not null
	private int category_key;	//not null
	private String name;		//not null
	
	private String img1;		//not null
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

}
