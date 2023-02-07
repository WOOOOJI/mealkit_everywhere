package com.admin.controller;


import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.dto.DashBoardDTO;
import com.admin.dto.FilterdDTO;
import com.admin.dto.OrderAVG;
import com.admin.dto.OrderDTO;
import com.admin.service.RealTimeAnalyzeService;

@RestController
public class RealTimeAnalyzeController {

	@Autowired
	RealTimeAnalyzeService service;


	@SuppressWarnings("unchecked")
	@RequestMapping("/getRealTimeData")
	public JSONObject getRealTimeData() {

		// 주문건당 통계
		OrderAVG orderavg = new OrderAVG();

		// 나이 차트
		List<OrderDTO> ageList = new ArrayList<>();
		// 성별 차트
		List<OrderDTO> genderList = new ArrayList<>();
		// 시간별 차트
		List<OrderDTO> chartList = new ArrayList<>();
		// 판매순위 리스트
		List<FilterdDTO> productList = new ArrayList<>();
		// 어제 매출 차트
		List<OrderDTO> lastDayChart = new ArrayList<>();

		// 대쉬보드 차트
		DashBoardDTO nowDash = new DashBoardDTO();
		DashBoardDTO totalDash = new DashBoardDTO();

		nowDash = service.realTimeDashBoard();
		totalDash = service.totalTimeDashBoard();
		//주문당 평균 판매량/판매금액
		orderavg = service.realTimeOrderAvg();
		//나이별 통계
		ageList = service.realTimeAgeRangeSales();
		//성별 통계
		genderList = service.realTimeGenderSales();
		// 실시간 판매 차트
		chartList = service.realTimeSalesChart();
		int[] arr=new int[24];
		int i=0;
		for(OrderDTO o:chartList) {
			arr[i]=o.getTotalSales();
			i++;
		}

		productList = service.RealTimefilterdData();
		lastDayChart = service.lastDayChart();
		int[] arr2 = new int[24];
		int i2 = 0;

		for(OrderDTO o : lastDayChart) {
			arr2[i2] = o.getTotalSales();
			i2++;
		}

		//성별 통계 JSONArray로 전달
		JSONArray genderArray=new JSONArray();
		int maleSales=0; int femaleSales=0;
		for(OrderDTO o:genderList) {
			if(o.getGender().equals("male")) maleSales=o.getTotalSales();
			if(o.getGender().equals("female")) femaleSales=o.getTotalSales();
		}
		JSONObject genderObj=new JSONObject();
		genderObj.put("male", maleSales);
		genderObj.put("female", femaleSales);
		genderArray.add(genderObj);

		//나이별 통계 JSONArray로 전달
		JSONArray ageArray=new JSONArray();
		int age10Sales=0; int age20Sales=0; int age30Sales=0; int age40Sales=0; int age50Sales=0; int age60Sales=0;
		for(OrderDTO o:ageList) {
			switch(o.getAgeRange()) {
			case("10"):case("10.0"): age10Sales=o.getTotalSales();  break;
			case("20"):case("20.0"): age20Sales=o.getTotalSales(); break;
			case("30"):case("30.0"): age30Sales=o.getTotalSales(); break;
			case("40"):case("40.0"): age40Sales=o.getTotalSales(); break;
			case("50"):case("50.0"): age50Sales=o.getTotalSales(); break;
			case("60"):case("60.0"): age60Sales=o.getTotalSales(); break;
			}
		}
		JSONObject ageObj=new JSONObject();
		ageObj.put("age10Sales", age10Sales);
		ageObj.put("age20Sales", age20Sales);
		ageObj.put("age30Sales", age30Sales);
		ageObj.put("age40Sales", age40Sales);
		ageObj.put("age50Sales", age50Sales);
		ageObj.put("age60Sales", age60Sales);
		ageArray.add(ageObj);
		// 뷰로 보낼 JSONObjcet 생성
		JSONObject json = new JSONObject();



		// json에 담아주기 (객체)
		json.put("nowDash", nowDash);
		json.put("totalDash", totalDash);
		json.put("orderavg", orderavg);
		json.put("chart", arr);
		json.put("ageData",ageArray);
		json.put("genderData",genderArray);

		json.put("productList", productList);
		json.put("lastDayChart", arr2);

		return json;
	}

}
