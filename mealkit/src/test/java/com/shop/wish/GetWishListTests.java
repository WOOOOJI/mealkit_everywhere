package com.shop.wish;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.WishDTO;
import com.shop.service.WishService;

@SpringBootTest
class GetWishListTests {

	@Inject
	WishService service;
	
	@Test
	void contextLoads() {
		System.out.println("찜 리스트 가져오기---------------------------------------------------");
		
		List<WishDTO> wishList = null;
		
		try {
			wishList = service.WishList(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("찜 리스트 결과 = "+wishList);
	
		System.out.println("찜 리스트 테스트 끝---------------------------------------------------");
		
	}


	

}
