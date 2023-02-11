package com.shop.order;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.OrderDTO;
import com.shop.service.OrderService;

@SpringBootTest
class CartToOrderTests {
	@Autowired
	OrderService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 장바구니의 상품들 가져오기 테스트 시작 ====================================");
		List<OrderDTO> list=null;
		int custKey = 4;
		list=service.cartToOrder(custKey);
		for(OrderDTO o:list) {
			System.out.println(o);
		}
		System.out.println("================================== 장바구니의 상품들 가져오기 테스트 끝 ====================================");
	}


	

}
