package com.shop.board;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.service.BoardService;

@SpringBootTest
class DeleteQnaTests {

	@Inject
	BoardService service;
	
	@Test
	void contextLoads() {
		System.out.println("문의 삭제---------------------------------------------------");
		

		try {
		 service.reviewDel(8);
		 System.out.println("삭제 성공하였습니다.");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("삭제 실패하였습니다.");
		}
	
		System.out.println("문의 삭제 테스트 끝---------------------------------------------------");
		
	}


	

}
