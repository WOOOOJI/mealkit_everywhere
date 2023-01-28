package com.shop.notice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CartDTO;
import com.shop.dto.Criteria;
import com.shop.dto.NoticeDTO;
import com.shop.service.CartService;
import com.shop.service.NoticeService;

@SpringBootTest
class GetEventListTests {
	@Autowired
	NoticeService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 이벤트 페이지 리스트로 가져오기 테스트 시작 ====================================");
		
		Criteria cri = new Criteria();
		List<NoticeDTO> eventList = new ArrayList<>();
		
		eventList = service.getEventList(cri);
		System.out.println("이벤트 리스트 가져오기 성공 :");
		if(eventList != null) {
			for(NoticeDTO d : eventList) {
				System.out.println(d);
			}
		}
		if(eventList == null) System.out.println("이벤트 리스트 가져오기 실패 :" + eventList);
		
		
		System.out.println("================================== 이벤트 페이지 리스트로 가져오기 테스트 끝 ====================================");
	}


	

}
