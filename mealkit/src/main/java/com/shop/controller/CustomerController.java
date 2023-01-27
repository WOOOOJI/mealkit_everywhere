package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.dto.CustomerDTO;
import com.shop.dto.OrderDTO;
import com.shop.dto.OrderDetailDTO;
import com.shop.service.CustomerService;
import com.shop.service.OrderDetailService;
import com.shop.service.OrderService;

@Controller
@RequestMapping("/customer")
public class CustomerController {		
	
	
	
	String dir="customer/";
	
	
	
	@Autowired
	CustomerService service;

	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDetailService orderDetailService;


	// 회원가입 폼
	@GetMapping("/memberForm")
	public String addMember(Model model) {
		return "customer/memberForm";
	}

	// 회원가입
	@PostMapping("/memberForm")
	public String addMember(CustomerDTO dto, Model model) {
		// System.out.println(dto.toString());
		int result = service.addMember(dto);
		model.addAttribute("result", result);
		return "customer/login";
	}

	// 아이디 중복체크
	@ResponseBody // 값 변환을 위해 필요
	@PostMapping("/idCheck")
	public int idCheck(CustomerDTO dto) throws Exception {
		int result = service.isEmailExist(dto); // 중복확인한 값을 int로 받음 return result
		return result;
	}

	// 로그인 폼
	@RequestMapping("/loginForm")
	public String loginForm(Model model) {
		return "customer/login";
	}

	// 로그인 하기
	@PostMapping("/login")
	public String login(CustomerDTO dto, Model model, HttpServletRequest req) throws Exception {
		// System.out.println(dto.toString());
		HttpSession session = req.getSession();
		CustomerDTO customerDTO = service.loginCheck(dto);
		System.out.println(customerDTO);
		if (customerDTO != null) {
			session.setAttribute("custKey", customerDTO.getCustKey());
			session.setAttribute("email", customerDTO.getEmail());
			session.setAttribute("username", customerDTO.getUsername());
			model.addAttribute("loginResult", "success");
			model.addAttribute("username", customerDTO.getUsername()); // 로그인 성공시 메인에서 '___님 환영합니다' 메세지
			System.out.println(session);
			return "trash";
		} else {
			model.addAttribute("loginResult", "fail"); // 로그인 실패시 '아이디와 비밀번호를 확인하세요.' 메세지
			model.addAttribute("content", "customer/login");
			return "customer/login";
		}
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate(); // 세션 지우기
		return "redirect:/";
	}

	// 아이디 찾기 폼
	@GetMapping("/findid")
	public String findid(Model model) {
		return "customer/findid";
	}

	// 아이디 찾기
	@PostMapping("/findId")
	public String findId(CustomerDTO dto, Model model) throws Exception {
		String result = service.findId(dto);
		model.addAttribute("result", result);

		if (result == null || result.equals("")) {
			return "customer/findid";
		}

		return "redirect:/customer/loginForm";
	}

	// 비밀번호 찾기 폼
	@GetMapping("/findpwd")
	public String findpwd(Model model) {

		return "customer/findpwd";
	}

	// 비밀번호 찾기
	@PostMapping("/findPwd")
	@ResponseBody
	public String findPwd(CustomerDTO dto) throws Exception {
		String result = service.findId(dto);
		return result;
	}

	// 비밀번호 리셋폼
	@PostMapping("/resetPwdForm")
	public String resetPwdForm(CustomerDTO dto, Model model) {
		CustomerDTO d = null;
		try {
			d = service.resetPwdForm(dto);
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (d != null) {
			model.addAttribute("custKey", d.getCustKey());
			return "customer/resetpwd";
		}
		model.addAttribute("num", 0);
		return "customer/findpwd"; //
	}

	// 비밀번호 재설정
	@PostMapping("/resetPwd")
	public String resetPwd(String pwd1, String pwd2, int custKey, Model model) {
		int result = 0;

		try {
			result = service.resetPwd(pwd1, pwd2, custKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result == 0) {
			model.addAttribute("result", result);
			return "customer/resetPwd";
		}
		result = 2;
		model.addAttribute("result", result);

		return "customer/login";
	}

	// 마이페이지 처음
	@RequestMapping("/mypage")
	public String mypageForm(Model model) {
		model.addAttribute("content","customer/mypage" );
		return "main";
	}

	// 마이페이지 비밀번호 변경폼
	@RequestMapping("/myresetPwdForm") 
	 public String myresetpwd(Model model, CustomerDTO dto) { 
		CustomerDTO d = null;
		try {
			d = service.resetPwdForm(dto);
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (d != null) {
			model.addAttribute("custKey", d.getCustKey());
			return "customer/resetpwd";
		}
		model.addAttribute("num", 0);
		return "customer/findpwd"; 
		
	}
	
	
	
	
	
	

	@RequestMapping("/orderlist")
	public String orderlist(Model model, HttpSession session) {
		//회원의 주문 리스트를 불러오기
		//1. cust_key를 세션에서 받아오기
		//2. cust_key를 통해 모든 total_list 불러오기
		List<OrderDTO> list=null;
		
		//cust_key를 세션에서 받아오기
		int custKey=(int)session.getAttribute("custKey");
		// 해당 회원의 모든 total_list를 받아오기
		list=orderService.getOrderWithItemInfo(custKey);

		model.addAttribute("list", list);
		model.addAttribute("content", dir+"orderlist");
		return "main";
	}

	@RequestMapping("/orderdetail")
	public String orderdetail(int orderKey,Model model, HttpSession session) {
		//주문 상세 정보를 보여주는 페이지
		//1. cust_key를 세션에서 받아오기
		//2. order_key를 이용해서 주문 상세내역/주문내역 가져오기
		List<OrderDetailDTO> odlist=null;
		OrderDTO order=null;
		
		int custKey=(int)session.getAttribute("custKey");
		
		
		odlist=orderDetailService.getOrderDetailByOrderkey(orderKey);
		order=orderService.getOrderByOrderKey(orderKey);
		
		model.addAttribute("order", order);
		model.addAttribute("list", odlist);
		model.addAttribute("content", dir+"orderdetail");
		return "main";
	}	
	
	
	//회원탈퇴 폼으로 이동
	@RequestMapping("/signoutForm")
	public String signOutForm() {
		return "customer/signout";
	}
	
	// 회원탈퇴
	@PostMapping("/signout")
	public String signOut(Model model, HttpSession session, CustomerDTO dto) {
		int custKey = (int)session.getAttribute("custKey");
		dto.setCustKey(custKey);
		int result = service.signOut(dto);
		if(result==1) {
			session.invalidate();
		}else{
			result=2;
		}
		model.addAttribute("result", result);
		return "customer/signout";
	}

}
