package com.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.dto.AdminDTO;
import com.admin.service.AdminService;

@Controller
public class AdminController {


	@Autowired
	AdminService service;

	@RequestMapping("/loginForm")
	public String loginForm() {
		return "login/loginForm";
	}


	@PostMapping("/login")
	public String login(String adminId, String adminPwd, Model model, HttpSession session) {
		AdminDTO dto = null;
		int result = 2;

		dto	= service.login(adminId, adminPwd);

		if(dto == null) {
			result = 1;
			model.addAttribute("result", result);
			return "login/loginForm";
		}

			model.addAttribute("result", result);
			session.setAttribute("adminId", dto.getAdminId());
			session.setAttribute("name", dto.getName());
			session.setAttribute("adminKey", dto.getAdminKey());

		return "main";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();

		return "login/loginForm";
	}
}
