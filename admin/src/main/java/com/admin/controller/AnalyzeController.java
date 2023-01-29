package com.admin.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.dto.ItemDTO;
import com.admin.dto.OrderDTO;
import com.admin.service.AnalyzeService;

@Controller
public class AnalyzeController {

	@Autowired
	AnalyzeService analyzeService;

	@RequestMapping("/monthanalyze")
	public String month(Model model) {

		String year = "2023";
		String month="01";

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
		ArrayList arr=new ArrayList();
		for(OrderDTO o:monthSalesChart) {
			arr.add(o.getTotalSales());
		}
		
		model.addAttribute("saleschart", arr);
		model.addAttribute("content", "monthanalyze/content");
		return "main";
	}

	@RequestMapping("/yearanalyze")
	public String year(Model model) {
		String year = "2022";

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
		ArrayList arr=new ArrayList();
		for(OrderDTO o:yearSalesChart) {
			arr.add(o.getTotalSales());
		}
		model.addAttribute("saleschart", arr);
		model.addAttribute("content", "yearanalyze/content");
		return "main";
	}

	@RequestMapping("/dayanalyze")
	public String day(Model model) {
		
		String year = "2022";
		String month="12";
		String day="30";

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
		}
		daySalesChart=analyzeService.daySalesChart(year,month,day);
		ArrayList arr=new ArrayList();
		for(OrderDTO o:daySalesChart) {
			arr.add(o.getTotalSales());
		}
		model.addAttribute("saleschart", arr);
		model.addAttribute("content", "dayanalyze/content");
		return "main";
	}

	@RequestMapping("/detailSearch")
	public String detailSearch(Model model) {
		model.addAttribute("content", "detailsearch/content");
		return "main";
	}
}
