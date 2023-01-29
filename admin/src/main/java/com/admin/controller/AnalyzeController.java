package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.dto.DashBoardDTO;
import com.admin.service.AnalyzeService;

@Controller
public class AnalyzeController {
	
	@Autowired
	AnalyzeService service;
	
	
	// 월별 대쉬보드 현황 가져오기 wooj
	@RequestMapping("/monthanalyze")
	public String month(Model model, String year, String month) {
		
		
		DashBoardDTO dash = service.dashBoardCardMonth(year, month);
		model.addAttribute("dash", dash);
		
		
		
		model.addAttribute("content", "monthanalyze/content");
		return "main";
	}
	
	
	// 년도별 대쉬보드 현황 가져오기 wooj
	@RequestMapping("/yearanalyze")
	public String year(Model model, String year) {
		
		
		
		DashBoardDTO dash = service.dashBoardCardYear(year);
		model.addAttribute("dash", dash);

		
		
		model.addAttribute("content", "yearanalyze/content");
		return "main";
	}
	
	
	// 일별 대쉬보드 현황 가져오기 wooj
	@RequestMapping("/dayanalyze")
	public String day(Model model, String year, String month, String day) {
		
		
		DashBoardDTO dash = service.dashBoardCardDay(year, month, day);
		model.addAttribute("dash", dash);

		
		
		model.addAttribute("content", "dayanalyze/content");
		return "main";
	}
	
	
	@RequestMapping("/detailSearch")
	public String detailSearch(Model model) {
		model.addAttribute("content", "detailsearch/content");
		return "main";
	}
}
