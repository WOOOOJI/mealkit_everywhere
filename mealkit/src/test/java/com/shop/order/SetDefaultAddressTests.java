package com.shop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.service.AddressService;

@SpringBootTest
class SetDefaultAddressTests {
	@Autowired
	AddressService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 기본 배송지 설정 테스트 시작 ====================================");
		int custKey=1;
		int addrKey=2;
		service.setDefaultAddress(custKey, addrKey);
		System.out.println("================================== 기본 배송지 설정 테스트 끝 ====================================");
	}


	

}
