package com.shop.board;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.BoardDTO;
import com.shop.dto.CustomerDTO;
import com.shop.dto.WishDTO;
import com.shop.service.BoardService;
import com.shop.service.CustomerService;
import com.shop.service.WishService;

@SpringBootTest
class GetQnaListTests {

	@Inject
	BoardService service;
	
	@Test
	void contextLoads() {
		System.out.println("문의 리스트 가져오기---------------------------------------------------");
		
		List<BoardDTO> boardList = null;
		
		try {
			boardList = service.qnaList(8);
			System.out.println("문의 리스트 가져오기 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("문의 리스트 가져오기 실패");
		}
		
		System.out.println("문의 리스트 결과 = "+ boardList);
	
		System.out.println("문의 리스트 가져오기 테스트 끝---------------------------------------------------");
		
	}


	

}
