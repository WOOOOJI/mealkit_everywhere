package com.shop.cart;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CartDTO;
import com.shop.service.CartService;

@SpringBootTest
class InsertItemToCartTests {
	@Autowired
	CartService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 회원의 장바구니에 상품 담기 테스트 시작 ====================================");
		int custKey = 1;
		int itemKey = 3;
		int cnt = 1;
		
		System.out.println("회원이 이전에 카트에 넣은 상품을 넣을려고 하는지 확인");
		
		System.out.println("넣고자 하는 아이템 키: "+ itemKey);
		
		
		List<CartDTO> dto = new ArrayList<>();
		try {
			dto = service.CartList(custKey);
			
			for(CartDTO c : dto) {			
				System.out.println("회원의 장바구니에 담겨있는 아이템 키들: "+c.getItemKey());
				
				if(itemKey == c.getItemKey()) {
					System.out.println("겹침. 기존에 있는 장바구니에 개수를 더해준다. ");
					System.out.println("넣고자 하는 아이템 키 :"+ itemKey);
					System.out.println("회원의 장바구니에 담겨있는 아이템 키: "+c.getItemKey());
					System.out.println("회원의 장바구니에 담겨있는 아이템 개수: "+c.getCnt());
					service.increaseCart(c.getCartKey(), itemKey, cnt);
					System.out.println("결과 : "+itemKey+" "+(c.getCnt()+cnt));
					return;
				}
			}
			
			System.out.println("겹치지 않았음 => 장바구니에 추가해준다.");
			service.increaseCart(custKey, itemKey, cnt);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("================================== 회원의 장바구니에 상품 담기 테스트 끝 ====================================");
	}


	

}
