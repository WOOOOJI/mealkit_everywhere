package com.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.dto.DashBoardDTO;
import com.admin.dto.FilterdDTO;
import com.admin.dto.ItemDTO;
import com.admin.dto.OrderDTO;
import com.admin.service.AnalyzeService;
import com.admin.service.CustomerService;
import com.admin.service.OrderService;

@Controller
public class AnalyzeController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	AnalyzeService analyzeService;

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/monthanalyze")
	public String month(String year, String month, Model model) {

		List<ItemDTO> categoryMonthAnalyze = null;
		List<OrderDTO> monthSalesChart=null;
		List<OrderDTO> lastMonthSalesChart=null;
		List<OrderDTO> monthTOP10List = new ArrayList<>();
		List<OrderDTO> monthBOT10List = new ArrayList<>();

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
		lastMonthSalesChart=analyzeService.lastMonthSalesChart(year, month);
		
		ArrayList arr=new ArrayList();
		for(OrderDTO o:monthSalesChart) {
			arr.add(o.getTotalSales());
		}
		ArrayList arr2=new ArrayList();
		for(OrderDTO o:lastMonthSalesChart) {
			arr2.add(o.getTotalSales());
		}
		
		DashBoardDTO dash = analyzeService.dashBoardCardMonth(year, month);
		monthTOP10List = orderService.getDayTOP10List(month);
		monthBOT10List = orderService.getDayTOP10List(month);
		model.addAttribute("dash", dash);
		model.addAttribute("saleschart", arr);
		model.addAttribute("salesMatchChart", arr2);
		model.addAttribute("monthTOP10List", monthTOP10List);
		model.addAttribute("monthBOT10List", monthBOT10List);
		model.addAttribute("content", "monthanalyze/content");
		return "main";
	}

	@RequestMapping("/yearanalyze")
	public String year(String year, Model model) {


		List<ItemDTO> categoryYearAnalyze = null;
		List<OrderDTO> yearSalesChart=null;
		List<OrderDTO> lastYearSalesChart=null;
		List<OrderDTO> yearTOP10List = new ArrayList<>();
		List<OrderDTO> yearBOT10List = new ArrayList<>();
		
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
		lastYearSalesChart=analyzeService.lastYearSalesChart(year);
		
		ArrayList arr=new ArrayList();
		for(OrderDTO o:yearSalesChart) {
			arr.add(o.getTotalSales());
		}
		ArrayList arr2=new ArrayList();
		for(OrderDTO o:lastYearSalesChart) {
			arr2.add(o.getTotalSales());
		}
		
		DashBoardDTO dash = analyzeService.dashBoardCardYear(year);
		yearTOP10List = orderService.getYearTOP10List(year);
		yearBOT10List = orderService.getYearTOP10List(year);
		model.addAttribute("dash", dash);
		model.addAttribute("saleschart", arr);
		model.addAttribute("salesMatchChart", arr2);
		model.addAttribute("yearMthlyList", yearTOP10List);
		model.addAttribute("yearBOT10List", yearBOT10List);
		model.addAttribute("content", "yearanalyze/content");
		return "main";
	}

	@RequestMapping("/dayanalyze")
	public String day(String year, String month, String day, Model model) {
		

		List<ItemDTO> categoryDayAnalyze = null;
		List<OrderDTO> daySalesChart=null;
		List<OrderDTO> lastDaySalesChart=null;
		List<OrderDTO> dayTOP10List = new ArrayList<>();
		List<OrderDTO> dayBOT10List = new ArrayList<>();
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
		}
		
		daySalesChart=analyzeService.daySalesChart(year,month,day);
		lastDaySalesChart=analyzeService.lastDaySalesChart(year,month,day);
		
		ArrayList arr=new ArrayList();
		for(OrderDTO o:daySalesChart) {
			arr.add(o.getTotalSales());
		}
		ArrayList arr2=new ArrayList();
		for(OrderDTO o:lastDaySalesChart) {
			arr2.add(o.getTotalSales());
		}
		
		DashBoardDTO dash = analyzeService.dashBoardCardDay(year, month, day);
		dayTOP10List = orderService.getDayTOP10List(day);
		dayBOT10List = orderService.getDayTOP10List(day);
		model.addAttribute("dash", dash);
		model.addAttribute("saleschart", arr);
		model.addAttribute("salesMatchChart", arr2);
		model.addAttribute("dayTOP10List", dayTOP10List);
		model.addAttribute("dayBOT10List", dayBOT10List);
		model.addAttribute("content", "dayanalyze/content");
		return "main";
	}


	@RequestMapping("/detailSearch")
	public String detailSearch(FilterdDTO filterdDTO, String gender, Model model) {
		
		if(gender != "noGender") {
			if(gender == "M"){
				filterdDTO.setGender1("1");
				filterdDTO.setGender2("3");
			}else {
				filterdDTO.setGender1("2");
				filterdDTO.setGender2("4");
			}
		}
		
		List<FilterdDTO> filterdDTOList = analyzeService.filterdData(filterdDTO);
		
		model.addAttribute("filterdDTOList", filterdDTOList);
		model.addAttribute("content", "detailsearch/content");
		return "main";
	}
	
	
}
