package com.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FilterdDTO {
	private int categoryKey;
	private String name;
	private int totPrice;
	private int salePct;
	private int sale;
	private int totCnt;
	
	private String age;
	private String gender;
	private String gender1;
	private String gender2;
	private String startDate;
	private String endDate;
	private String align;
	
}