package com.shop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.service.AddressService;

@SpringBootTest
class AddrRemoveTests {
	@Autowired
	AddressService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 배송지 삭제하기 테스트 시작 ====================================");
		int addrKey=4;
		service.remove(addrKey);
		System.out.println("================================== 배송지 삭제하기 테스트 끝 ====================================");
	}


	

}
