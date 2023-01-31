package com.admin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.dto.DashBoardDTO;
import com.admin.dto.ItemDTO;
import com.admin.dto.OrderDTO;
import com.admin.service.AnalyzeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AnalyzeController {

	@Autowired
	AnalyzeService analyzeService;

	@RequestMapping("/monthanalyze")
	public String month(String year, String month, Model model) {

		List<ItemDTO> categoryMonthAnalyze = null;
		List<OrderDTO> monthSalesChart=null;
		// 카테고리별 연간 판매량, 판매액
		categoryMonthAnalyze = analyzeService.categoryMonthAnalyze(year,month);
		for (ItemDTO i : categoryMonthAnalyze) {
			switch (i.getCategoryKey()) {
			// categoryKey를 봐서 1:한식 2:중식 등 차례대로 전달
			case 1:
				model.addAttribute("koreanSum", i.getSalesSum());
				model.addAttribute("koreanCnt", i.getSalesCnt());
				break;
			case 2:
				model.addAttribute("chineseSum", i.getSalesSum());
				model.addAttribute("chineseCnt", i.getSalesCnt());
				break;
			case 3:
				model.addAttribute("japaneseSum", i.getSalesSum());
				model.addAttribute("japaneseCnt", i.getSalesCnt());
				break;
			case 4:
				model.addAttribute("usSum", i.getSalesSum());
				model.addAttribute("usCnt", i.getSalesCnt());
				break;
			}
		}
		
		//월별 매출 차트
		monthSalesChart=analyzeService.monthSalesChart(year, month);
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(OrderDTO o:monthSalesChart) {
			arr.add(o.getTotalSales());
		}
		
		DashBoardDTO dash = analyzeService.dashBoardCardMonth(year, month);
		
		model.addAttribute("dash", dash);
		model.addAttribute("saleschart", arr);
		model.addAttribute("content", "monthanalyze/content");
		return "main";
	}

	@RequestMapping("/yearanalyze")
	public String year(String year, Model model) {


		List<ItemDTO> categoryYearAnalyze = null;
		List<OrderDTO> yearSalesChart=null;

		// 카테고리별 연간 판매량, 판매액
		categoryYearAnalyze = analyzeService.categoryYearAnalyze(year);
		for (ItemDTO i : categoryYearAnalyze) {
			switch (i.getCategoryKey()) {
			// categoryKey를 봐서 1:한식 2:중식 등 차례대로 전달
			case 1:
				model.addAttribute("koreanSum", i.getSalesSum());
				model.addAttribute("koreanCnt", i.getSalesCnt());
				break;
			case 2:
				model.addAttribute("chineseSum", i.getSalesSum());
				model.addAttribute("chineseCnt", i.getSalesCnt());
				break;
			case 3:
				model.addAttribute("japaneseSum", i.getSalesSum());
				model.addAttribute("japaneseCnt", i.getSalesCnt());
				break;
			case 4:
				model.addAttribute("usSum", i.getSalesSum());
				model.addAttribute("usCnt", i.getSalesCnt());
				break;
			}
		}
		
		yearSalesChart=analyzeService.yearSalesChart(year);
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(OrderDTO o:yearSalesChart) {
			arr.add(o.getTotalSales());
		}
		
		
		DashBoardDTO dash = analyzeService.dashBoardCardYear(year);
		model.addAttribute("dash", dash);
		
		model.addAttribute("saleschart", arr);
		model.addAttribute("content", "yearanalyze/content");
		return "main";
	}

	@RequestMapping("/dayanalyze")
	public String day(String year, String month, String day, Model model) {
		

		List<ItemDTO> categoryDayAnalyze = null;
		List<OrderDTO> daySalesChart=null;
		// 카테고리별 연간 판매량, 판매액
		categoryDayAnalyze = analyzeService.categoryDayAnalyze(year,month,day);
		for (ItemDTO i : categoryDayAnalyze) {
			switch (i.getCategoryKey()) {
			// categoryKey를 봐서 1:한식 2:중식 등 차례대로 전달
			case 1:
				model.addAttribute("koreanSum", i.getSalesSum());
				model.addAttribute("koreanCnt", i.getSalesCnt());
				break;
			case 2:
				model.addAttribute("chineseSum", i.getSalesSum());
				model.addAttribute("chineseCnt", i.getSalesCnt());
				break;
			case 3:
				model.addAttribute("japaneseSum", i.getSalesSum());
				model.addAttribute("japaneseCnt", i.getSalesCnt());
				break;
			case 4:
				model.addAttribute("usSum", i.getSalesSum());
				model.addAttribute("usCnt", i.getSalesCnt());
				break;	
			}
			
			System.out.println(i.getSalesCnt());
		}
		
		
		
		daySalesChart=analyzeService.daySalesChart(year,month,day);
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(OrderDTO o:daySalesChart) {
			arr.add(o.getTotalSales());
		}
		
		DashBoardDTO dash = analyzeService.dashBoardCardDay(year, month, day);
		model.addAttribute("dash", dash);
		model.addAttribute("saleschart", arr);
		model.addAttribute("content", "dayanalyze/content");
		return "main";
	}


	@RequestMapping("/detailSearch")
	public String detailSearch(@RequestParam(value = "categoryKey", defaultValue = "-1") int categoryKey,
			@RequestParam(value = "age", defaultValue = "noAge") String age,
			@RequestParam(value = "gender", defaultValue = "noGender") String gender, String startDate, String endDate, Model model) {
		

		DashBoardDTO dash = new DashBoardDTO();
		
		
		

		List<OrderDTO> ageRangeSales=null;
		List<OrderDTO> genderSales=null;
		
		//처음 접속 시 날짜를 기본으로 전날로 설정
		if(startDate==null||startDate.equals("")) {
		Calendar cal = Calendar.getInstance();
		String format = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		cal.add(cal.DATE, -1); //날짜를 하루 뺀다.
		startDate = sdf.format(cal.getTime());
		endDate = sdf.format(cal.getTime());
		}
		System.out.println(startDate+endDate);
		//성별 처리
		String gender1=""; String gender2="";
		if(!gender.equals("noGender")) {
			gender1=gender.split(",")[0];
			gender2=gender.split(",")[1];
		}

		//나이대별 판매량 조회 ===========================================
		ageRangeSales=analyzeService.ageRangeSales(categoryKey, gender, gender1, gender2, startDate, endDate);
		
		//나이대별 판매량 조회한 것을 나이대에 맞게 addAttribute 수행
		for(OrderDTO o:ageRangeSales) {
			switch(o.getAgeRange()) {
			case("10"):case("10.0"): model.addAttribute("age10Sales", o.getTotalSales()); break;
			case("20"):case("20.0"): model.addAttribute("age20Sales", o.getTotalSales()); break;
			case("30"):case("30.0"): model.addAttribute("age30Sales", o.getTotalSales()); break;
			case("40"):case("40.0"): model.addAttribute("age40Sales", o.getTotalSales()); break;
			case("50"):case("50.0"): model.addAttribute("age50Sales", o.getTotalSales()); break;
			case("60"):case("60.0"): model.addAttribute("age60Sales", o.getTotalSales()); break;
			}
		}
		

		// 성별 판매량 조회 =========================================
		genderSales=analyzeService.genderSales(categoryKey, age, startDate, endDate);
		
		for(OrderDTO o:genderSales) {
			switch(o.getGender()) {
			case("male"): model.addAttribute("maleSales", o.getTotalSales()); break;
			case("female"): model.addAttribute("femaleSales", o.getTotalSales()); break;
			}
		}
		
		switch(categoryKey) {
			case(1):model.addAttribute("categoryName", "한식"); break;
			case(2):model.addAttribute("categoryName", "중식"); break;
			case(3):model.addAttribute("categoryName", "일식"); break;
			case(4):model.addAttribute("categoryName", "양식"); break;
		}
		
		switch(gender1) {
			case("1"): model.addAttribute("genderName", "남성"); break;
			case("2"): model.addAttribute("genderName", "여성"); break;
		}

		// 상세조회 대시보드======================================================
		dash = analyzeService.dashBoardCardDetail(startDate, endDate, gender, gender1, gender2, age, categoryKey);
		
		model.addAttribute("dash", dash);
		model.addAttribute("categoryKey", categoryKey);
		model.addAttribute("age", age);
		model.addAttribute("gender", gender);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("content", "detailsearch/content");
		

		return "main";
	}
}