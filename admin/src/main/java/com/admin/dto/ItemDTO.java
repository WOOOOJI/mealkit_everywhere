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
	private int itemKey;		//not null
	private int categoryKey;	//not null
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
	
	
	private MultipartFile imgFile1;
	private MultipartFile imgFile2;
	private MultipartFile imgFile3;
	private MultipartFile imgFile4;
	private MultipartFile imgFile5;
	
	//카테고리별 판매 통계에 필요한 변수
	private int salesSum;
	private int salesCnt;
	
	

}

