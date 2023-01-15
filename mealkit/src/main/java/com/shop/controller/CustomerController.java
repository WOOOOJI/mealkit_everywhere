package com.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.dto.CustomerDTO;
import com.shop.mapper.CustomerMapper;
import com.shop.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	@Autowired
	CustomerMapper mapper;

	// 회원가입 폼
	@GetMapping("/memberForm")
	public String addMember(Model model) {
		model.addAttribute("title", "회원가입");
		model.addAttribute("content", "customer/memberForm");
		return "main";
	}

	// 회원가입
	@PostMapping("/memberForm")
	public String addMember(CustomerDTO dto, Model model) {
		// System.out.println(dto.toString());
		int result = service.addMember(dto);
		model.addAttribute("content", "customer/login"); // 회원가입 성공시 로그인 페이지로 가도록 함
		model.addAttribute("result", result);
		return "main";
	}

	// 아이디 중복체크
	@ResponseBody // 값 변환을 위해 필요
	@PostMapping("/idCheck")
	public int idCheck(CustomerDTO dto) throws Exception {
		int result = service.isEmailExist(dto); // 중복확인한 값을 int로 받음 return result
		return result;
	}

	// 로그인 폼
	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("content", "customer/login");
		return "main";
	}

	// 로그인 하기
	@PostMapping("/login")
	public String login(CustomerDTO dto, Model model, HttpSession session) throws Exception {
		// System.out.println(dto.toString());

		CustomerDTO customerDTO = service.loginCheck(dto);
		if (customerDTO != null) {
			session.setAttribute("cust_key", customerDTO.getCust_key());
			model.addAttribute("loginResult", "success");
			model.addAttribute("username", customerDTO.getUsername()); // 로그인 성공시 메인에서 '___님 환영합니다' 메세지
			return "main";
		} else {
			model.addAttribute("loginResult", "fail"); // 로그인 실패시 '아이디와 비밀번호를 확인하세요.' 메세지
			model.addAttribute("content", "customer/login");
			return "main";
		}
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate(); // 세션 지우기
		return "main";
	}

	// 아이디 찾기 폼
	@GetMapping("/findid")
	public String findid(Model model) {
		model.addAttribute("content", "customer/findid");
		return "main";
	}

	// 아이디 찾기
	@PostMapping("/findId")
	@ResponseBody
	public String findId(CustomerDTO dto) throws Exception {
		String result = service.findId(dto);
		return result;
	}

	// 비밀번호 찾기 폼
	@GetMapping("/findpwd")
	public String findpwd(Model model) {
		model.addAttribute("content", "customer/findpwd");
		return "main";
	}

	// 비밀번호 찾기
	@PostMapping("/findPwd")
	@ResponseBody
	public String findPwd(CustomerDTO dto) throws Exception {
		String result = service.findId(dto);				
		return result;
	}
	
	// 비밀번호 리셋폼
	@PostMapping("/resetPwd")
	@ResponseBody
	public String resetPwd(CustomerDTO dto, Model model) {
		CustomerDTO d = null;
		try {
			d = service.resetPwd(dto);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		if(d != null) {
			model.addAttribute("cust_key", d.getCust_key());
			return "resetpwd";
		}
		model.addAttribute("num", 0);
		return "findpwd";
	}
	
}
