package com.admin.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.BoardDTO;
import com.admin.dto.Criteria;
import com.admin.service.BoardService;


@SpringBootTest
class GetQnaListTest {

	@Autowired
	BoardService service;

	@Test
	void contextLoads() {
		System.out.println("--------QnA 리스트 가져오기 테스트 시작 ---------");


		Criteria cri = new Criteria();
		List<BoardDTO> boardList = null;

		boardList = service.getQnaList(cri);
		System.out.println("QnA 리스트 가져오기 성공");
		if(boardList != null) {
			for(BoardDTO b : boardList) {
				System.out.println(b);
			}
		}
		if(boardList == null) System.out.println("QnA 리스트 가져오기 실패");
		System.out.println("--------테스트 끝 ---------");
	}

}
