package com.shop.cart;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CartDTO;
import com.shop.service.CartService;

@SpringBootTest
class CartItemDeleteTests {
	@Autowired
	CartService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 회원의 장바구니에 담겨있는 상품 삭제 테스트 시작 ====================================");
		int cartKey = 1;
		System.out.println("삭제할 장바구니 번호: "+cartKey);
		
		try {
			service.remove(cartKey);
			System.out.println("장바구니 삭제 성공");
		} catch (Exception e) {
			System.out.println("장바구니 삭제 실패");
			e.printStackTrace();
		}
		
		System.out.println("================================== 회원의 장바구니에 담겨있는 상품 삭제 테스트 끝 ====================================");
	}


	

}
