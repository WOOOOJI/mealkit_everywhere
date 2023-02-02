package com.shop.customer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CustomerDTO;
import com.shop.service.CustomerService;

@SpringBootTest
class FindPwdTests {

	@Inject
	CustomerService service;
	
	@Test
	void contextLoads() {
		System.out.println("비밀번호 찾기 테스트 시작---------------------------------------------------");
		
		CustomerDTO dto = new CustomerDTO();
		dto.setEmail("multicam12@gmail.com");
		dto.setTel("010-6356-6464");
		
		
		try {
			dto = service.resetPwdForm(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("비밀번호 찾기 결과 =" + dto);
		if(dto != null ) {
			System.out.println("비밀번호 찾기 성공..");
		}else {
			System.out.println("비밀번호 찾기 실패..");
		}
		
		System.out.println("비밀번호 찾기 테스트 끝---------------------------------------------------");
		
	}


	

}
