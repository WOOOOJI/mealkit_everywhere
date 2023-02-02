package com.admin.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.service.BoardService;


@SpringBootTest
class DeleteReviewTest {
	
	@Autowired
	BoardService service;
	
	@Test
	void contextLoads() {
		System.out.println("Review 삭제 테스트 시작---------------------------------------------------");
		
		try {
		 service.reviewDel(1);		 
		 System.out.println("삭제 성공하였습니다.");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("삭제 실패하였습니다.");
		}
	
		System.out.println("Review 삭제 테스트 끝---------------------------------------------------");
	}

}
