package com.shop.notice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.CartDTO;
import com.shop.dto.NoticeDTO;
import com.shop.service.CartService;
import com.shop.service.NoticeService;

@SpringBootTest
class GetEventDetailTests {
	@Autowired
	NoticeService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 이벤트 상세페이지 가져오기 테스트 시작 ====================================");
		
		int noticeKey = 2;
		System.out.println("가져올 이벤트 페이지 고유 키: "+ noticeKey);
		
		NoticeDTO dto = service.eventDetail(noticeKey);
		
		if(dto != null) System.out.println("이벤트 상세 페이지 가져오기 성공 :" + dto);
		if(dto == null) System.out.println("이벤트 상세 페이지 가져오기 실패 :" + dto);
		
		System.out.println("================================== 이벤트 상세페이지 가져오기 테스트 끝 ====================================");
	}


	

}
