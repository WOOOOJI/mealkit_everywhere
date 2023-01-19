package com.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("들어왔니?....");
		return "login/loginForm";
	}
}
