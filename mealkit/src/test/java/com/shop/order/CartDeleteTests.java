package com.shop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.service.CartService;

@SpringBootTest
class CartDeleteTests {
	@Autowired
	CartService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 장바구니의 삭제 테스트 시작 ====================================");
		int custKey = 4;
		service.cartDelete(custKey);
		System.out.println("================================== 장바구니의 삭제 테스트 끝 ====================================");
	}


	

}
