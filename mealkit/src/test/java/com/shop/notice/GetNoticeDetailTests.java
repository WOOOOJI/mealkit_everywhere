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
class GetNoticeDetailTests {
	@Autowired
	NoticeService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 공지사항 상세페이지 가져오기 테스트 시작 ====================================");
		
		int noticeKey = 4;
		System.out.println("가져올 공지사항 페이지 고유 키: "+ noticeKey);
		
		NoticeDTO dto = service.noticeDetail(noticeKey);
		
		if(dto != null) System.out.println("공지사항 상세 페이지 가져오기 성공 :" + dto);
		if(dto == null) System.out.println("공지사항 상세 페이지 가져오기 실패 :" + dto);
		
		System.out.println("================================== 공지사항 상세페이지 가져오기 테스트 끝 ====================================");
	}


	

}
