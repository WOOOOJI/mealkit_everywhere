package com.shop.customer;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CustomerDTO;
import com.shop.service.CustomerService;

@SpringBootTest
class FindIdTests {

	@Inject
	CustomerService service;
	
	@SuppressWarnings("null")
	@Test
	void contextLoads() {
		System.out.println("아이디 찾기 테스트 시작---------------------------------------------------");
		
		CustomerDTO dto = new CustomerDTO();
		dto.setUsername("한길동");
		dto.setTel("010-6356-6464");
		
		
		String result="";
		try {
			result = service.findId(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("아이디 찾기 결과 =" + result);
		if(result != null || result.equals("") ) {
			System.out.println("아이디 찾기 성공..");
		}else {
			System.out.println("아이디 찾기 실패..");
		}
		
		System.out.println("아이디 찾기 테스트 끝---------------------------------------------------");
		
	}


	

}
