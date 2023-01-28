package com.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String main(Model model, HttpSession session) {
		model.addAttribute("content","content");
		return "main";
	}
	
	
	@RequestMapping("/monthanalyze")
	public String month(Model model) {
		model.addAttribute("content", "monthanalyze/content");
		return "main";
	}
	
	
	
	@RequestMapping("/yearanalyze")
	public String year(Model model) {
		model.addAttribute("content", "yearanalyze/content");
		return "main";
	}
	
	@RequestMapping("/dayanalyze")
	public String day(Model model) {
		model.addAttribute("content", "dayanalyze/content");
		return "main";
	}
	
	
	@RequestMapping("/detailSearch")
	public String detailSearch(Model model) {
		model.addAttribute("content", "detailsearch/content");
		return "main";
	}
	
	
	
	
	
}
