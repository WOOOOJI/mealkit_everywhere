package com.shop.customer;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CustomerDTO;
import com.shop.service.CustomerService;

@SpringBootTest
class SignUpTests {

	@Inject
	CustomerService service;
	
	@Test
	void contextLoads() {
		System.out.println("회원가입 테스트 시작---------------------------------------------------");
		
		CustomerDTO dto = new CustomerDTO();
		dto.setEmail("abcde5009@gmail.com");
		dto.setUserpwd("Abcde123!");
		dto.setUsername("이상아");
		dto.setTel("01011111111");
		dto.setJumin("111111");
		dto.setGender(2);
		
		System.out.println("회원가입시 필요한 데이터 = " + dto);
		
		int result = service.addMember(dto);
		System.out.println("회원가입 결과 =" + result);
		if(result == 1) {
			System.out.println("테스트 성공하셨어요.");
		}else {
			System.out.println("테스트 실패하셨어요..");
		}
		
		System.out.println("회원가입 테스트 끝---------------------------------------------------");
		
	}


	

}
