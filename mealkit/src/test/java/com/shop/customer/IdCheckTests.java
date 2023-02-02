package com.shop.customer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CustomerDTO;
import com.shop.service.CustomerService;

@SpringBootTest
class IdCheckTests {

	@Inject
	CustomerService service;
	
	@Test
	void contextLoads() {
		System.out.println("회원가입 테스트 시작---------------------------------------------------");
		
		CustomerDTO dto = new CustomerDTO();
		dto.setEmail("abcde5009@gmail.com");
		
		
		System.out.println("중복검사할 아이디 = " + dto);
		
		int result=0;
		try {
			result = service.isEmailExist(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("아이디 중복 체크 결과 =" + result);
		if(result == 1) {
			System.out.println("아이디 중복입니다..");
		}else {
			System.out.println("아이디 중복 아닙니다..");
		}
		
		System.out.println("아이디 중복 체크 테스트 끝---------------------------------------------------");
		
	}


	

}
