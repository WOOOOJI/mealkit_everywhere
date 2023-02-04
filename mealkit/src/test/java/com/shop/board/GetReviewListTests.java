package com.shop.board;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.BoardDTO;
import com.shop.dto.Criteria;
import com.shop.dto.CustomerDTO;
import com.shop.dto.WishDTO;
import com.shop.service.BoardService;
import com.shop.service.CustomerService;
import com.shop.service.WishService;

@SpringBootTest
class GetReviewListTests {

	@Inject
	BoardService service;
	
	@Test
	void contextLoads() {
		System.out.println("후기 리스트 가져오기---------------------------------------------------");
		
		int custKey = 3;
		
		Criteria cri = new Criteria();
		List<BoardDTO> boardList = new ArrayList<>();
		cri.setCustKey(custKey);
		
		boardList = service.getReviewsList(cri);
		System.out.println("후기 리스트 가져오기 성공 :" + boardList);
		if(boardList != null) {
			for(BoardDTO b : boardList) {
				System.out.println(b);
			}
		}
		if(boardList == null) System.out.println("후기 리스트 가져오기 실패 :" + boardList);
		
		
	
		System.out.println("후기 리스트 가져오기 테스트 끝---------------------------------------------------");
		
	}


	

}
