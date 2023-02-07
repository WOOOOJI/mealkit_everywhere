package com.shop.customer;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.service.CustomerService;

@SpringBootTest
class ResetPwdTests {

	@Inject
	CustomerService service;
	
	@Test
	void contextLoads() {
		System.out.println("비밀번호 재설정 테스트 시작---------------------------------------------------");
		
		int result=0;
		try {
			result = service.resetPwd("aaaaa12", 27);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("비밀번호 재설정 결과 =" + result);
		if(result == 1) {
			System.out.println("비밀번호 재설정 성공..");
		}else {
			System.out.println("비밀번호 재설정 실패..");
		}
		
		System.out.println("비밀번호 재설정 테스트 끝---------------------------------------------------");
		
	}


	

}
