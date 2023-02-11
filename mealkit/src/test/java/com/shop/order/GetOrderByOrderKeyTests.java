package com.shop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.OrderDTO;
import com.shop.service.OrderService;

@SpringBootTest
class GetOrderByOrderKeyTests {
	@Autowired
	OrderService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("==================================  orderKey로 order 가져오기 테스트 시작 ====================================");
		OrderDTO result=null;
		int orderKey = 1201;
		result=service.getOrderByOrderKey(orderKey);
		System.out.println(result);
		System.out.println("================================== orderKey로 order 가져오기 테스트 끝 ====================================");
	}


	

}
