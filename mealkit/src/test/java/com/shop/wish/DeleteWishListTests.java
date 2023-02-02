package com.shop.wish;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CustomerDTO;
import com.shop.dto.WishDTO;
import com.shop.service.CustomerService;
import com.shop.service.WishService;

@SpringBootTest
class DeleteWishListTests {

	@Inject
	WishService service;
	
	@Test
	void contextLoads() {
		System.out.println("찜 아이템 삭제---------------------------------------------------");
		

		try {
		 service.remove(3);
		 System.out.println("삭제 성공하였습니다.");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("삭제 실패하였습니다.");
		}
	
		System.out.println("찜 아이템 테스트 끝---------------------------------------------------");
		
	}


	

}
