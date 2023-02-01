package com.admin.controller;


import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.dto.DashBoardDTO;
import com.admin.dto.OrderAVG;
import com.admin.dto.OrderDTO;
import com.admin.service.RealTimeAnalyzeService;

@RestController
public class RealTimeAnalyzeController {
	
	@Autowired
	RealTimeAnalyzeService service;
	
	
	@RequestMapping("/getRealTimeData")
	public JSONObject getRealTimeData() {
		
		// 주문건당 통계
		OrderAVG avg = new OrderAVG();
		
		// 나이 차트
		List<OrderDTO> ageList = new ArrayList<OrderDTO>();
		// 성별 차트
		List<OrderDTO> genderList = new ArrayList<OrderDTO>();
		// 시간별 차트
		List<OrderDTO> chartList = new ArrayList<OrderDTO>();
		
		// 대쉬보드 차트
		DashBoardDTO nowDash = new DashBoardDTO();
		DashBoardDTO totalDash = new DashBoardDTO();
		
		nowDash = service.realTimeDashBoard();
		totalDash = service.totalTimeDashBoard();
		avg = service.realTimeOrderAvg();
		ageList = service.realTimeAgeRangeSales();
		genderList = service.realTimeGenderSales();
		chartList = service.realTimeSalesChart();
		
		
		// 뷰로 보낼 JSONObjcet 생성
		JSONObject json = new JSONObject();
		
		System.out.println(nowDash);
		// json에 담아주기 (객체)
		json.put("nowDash", nowDash);
		json.put("totalDash", totalDash);
		
		
		
		return json;
	}
	
}
