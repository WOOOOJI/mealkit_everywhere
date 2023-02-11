package com.shop.customer;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.OrderDTO;
import com.shop.service.OrderService;

@SpringBootTest
class GetOrderWithItemInfoTests {
	@Autowired
	OrderService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 상품정보 포함한 주문 가져오기 테스트 시작 ====================================");
		List<OrderDTO> list=null;
		int custKey=1;
		list=service.getOrderWithItemInfo(custKey);
		for(OrderDTO o:list) {
			System.out.println(o);
		}
		System.out.println("================================== 상품정보 포함한 주문 가져오기 테스트 끝 ====================================");
	}


	

}
