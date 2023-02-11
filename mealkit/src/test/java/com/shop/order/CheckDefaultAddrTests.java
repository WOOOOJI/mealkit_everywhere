package com.shop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.AddressDTO;
import com.shop.service.AddressService;

@SpringBootTest
class CheckDefaultAddrTests {
	@Autowired
	AddressService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 장바구니의 상품들 가져오기 테스트 시작 ====================================");
		AddressDTO result=null;
		int custKey = 4;
		result=service.checkDefault(custKey);
		System.out.println(result);

		System.out.println("================================== 장바구니의 상품들 가져오기 테스트 끝 ====================================");
	}


	

}
