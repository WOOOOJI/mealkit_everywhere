package com.shop.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.dto.CustomerDTO;
import com.shop.service.CustomerService;
import com.shop.service.KakaoService;

@Controller
@RequestMapping("/oauth")
public class KakaoController {
	
	@Autowired
	KakaoService service;
	
	@Autowired
	CustomerService cust_service;
	
	
    @GetMapping("/kakao")
    public String kakaologin(@RequestParam String code, Model model, HttpSession session) throws Exception {
    	//System.out.println("#########" + code);
    	String access_Token = service.getAccessToken(code); 
    	HashMap<String, Object> userInfo = service.getUserInfo(access_Token);
    	
    	System.out.println(userInfo);
    	System.out.println("#access_Token : " + access_Token);
		System.out.println("#nickname: " + userInfo.get("nickname"));
		System.out.println("#email : " + userInfo.get("email"));
		
		Object nickname = userInfo.get("nickname"); 
		String cname = String.valueOf(nickname); // Object를 String으로 변환
		//System.out.println(cname);
		
		Object kemail = userInfo.get("email");
		String kemail2 = String.valueOf(kemail); // String 형으로 변환
		
		CustomerDTO dto = new CustomerDTO();
		//System.out.println("데이터연결안했다"+dto);
		System.out.println("#"+kemail);
		System.out.println("#"+nickname);
		dto.setEmail(kemail2);
		dto.setUsername(cname);
		
		System.out.println(cust_service.isEmailExist(dto));
		
		// db 중복 저장 막기. 1보다 작으면 중복 없음(신규 회원 가입)
		 if(cust_service.isEmailExist(dto)<1) {
			 cust_service.addMember(dto); //신규 유저 생성
		 }
		 
		int cust_key = service.findCustKey(kemail2);
		 
		session.setAttribute("email", dto.getEmail());
		session.setAttribute("cust_key", cust_key);
				model.addAttribute("loginResult", "success");
				model.addAttribute("username", dto.getUsername());
		
		return "main";
    }
 

}