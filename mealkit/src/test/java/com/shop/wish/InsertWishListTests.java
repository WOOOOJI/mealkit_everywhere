package com.shop.wish;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.WishDTO;
import com.shop.service.WishService;

@SpringBootTest
class InsertWishListTests {

	@Inject
	WishService service;
	
	@Test
	void contextLoads() {
		System.out.println("찜 아이템 담기---------------------------------------------------");
		List<WishDTO> list = new ArrayList<WishDTO>();
		int itemKey=5;
		int custKey=3;
		try {
			list = service.WishList(custKey);
			for(WishDTO w : list) {
				if(w.getItemKey()==itemKey) {
					System.out.println("이미 찜한 아이템입니다.");
					return;
				}
			}
			service.insertWish(custKey, itemKey);
			System.out.println("찜 아이템 담기 성공");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("찜 아이템 담기 실패");
		}
	
		System.out.println("찜 아이템 담기 테스트 끝---------------------------------------------------");
		
	}

}
