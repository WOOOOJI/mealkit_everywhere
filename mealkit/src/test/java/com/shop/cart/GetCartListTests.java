package com.shop.cart;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CartDTO;
import com.shop.service.CartService;

@SpringBootTest
class GetCartListTests {
	@Autowired
	CartService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 회원의 장바구니 리스트 가져오기 테스트 시작 ====================================");
		List<CartDTO> cartList = null;
		int custKey = 1;
		
		
		try {
			cartList = service.CartList(custKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("조회할 카트의 회원번호: "+custKey);
		System.out.println("조회한 카트의 상품 리스트: "+cartList);
	
		
		System.out.println("================================== 회원의 장바구니 리스트 가져오기 테스트 끝 ====================================");
	}


	

}
