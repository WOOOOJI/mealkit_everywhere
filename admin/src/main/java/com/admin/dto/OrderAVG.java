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
public class OrderAVG {
	public String stackedPrice;
	public String stackedCnt;
	public String realtimePrice;
	public String realtimeCnt;
}