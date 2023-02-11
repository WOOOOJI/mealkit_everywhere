package com.shop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.service.OrderService;

@SpringBootTest
class CreateBlankTests {
	@Autowired
	OrderService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 더미 주문데이터 만들기 테스트 시작 ====================================");
		int custKey=1;
		service.createBlank(custKey);
		System.out.println("================================== 더미 주문데이터 만들기 테스트 끝 ====================================");
	}


	

}
