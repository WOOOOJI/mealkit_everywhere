package com.shop.customer;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CustomerDTO;
import com.shop.service.CustomerService;

@SpringBootTest
class LoginTests {

	@Inject
	CustomerService service;
	
	@Test
	void contextLoads() {
		System.out.println("로그인 테스트 시작---------------------------------------------------");
		
		CustomerDTO dto = new CustomerDTO();
		dto.setEmail("momo@gmail.com");
		dto.setUserpwd("momo");
		
		System.out.println("로그인  = " + dto);
		
		try {
			dto = service.loginCheck(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(dto != null) {
			System.out.println("로그인 성공..");
		}else {
			System.out.println("로그인 실패..");
		}
		
		System.out.println("로그인 테스트 끝---------------------------------------------------");
		
	}


	

}
