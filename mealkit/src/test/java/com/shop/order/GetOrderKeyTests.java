package com.shop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.service.OrderService;

@SpringBootTest
class GetOrderKeyTests {
	@Autowired
	OrderService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 가장 최근 주문 가져오기 테스트 시작 ====================================");
		int orderKey=0;
		int custKey = 4;
		orderKey=service.getOrderkey(custKey);
		System.out.println(orderKey);
		System.out.println("================================== 가장 최근 주문 가져오기 테스트 끝 ====================================");
	}


	

}
