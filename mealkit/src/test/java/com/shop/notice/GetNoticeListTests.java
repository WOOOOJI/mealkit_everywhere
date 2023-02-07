package com.shop.notice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.Criteria;
import com.shop.dto.NoticeDTO;
import com.shop.service.NoticeService;

@SpringBootTest
class GetNoticeListTests {
	@Autowired
	NoticeService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 공지사항 페이지 리스트로 가져오기 테스트 시작 ====================================");
		
		Criteria cri = new Criteria();
		List<NoticeDTO> noticeList = new ArrayList<>();
		
		noticeList = service.getEventList(cri);
		
		if(noticeList != null) {
			System.out.println("공지사항 리스트 가져오기 성공:");
			for(NoticeDTO d : noticeList) {
				System.out.println(d);
			}
		}
		if(noticeList == null) System.out.println("공지사항 리스트 가져오기 실패 :" + noticeList);
		
		
		System.out.println("================================== 공지사항 페이지 리스트로 가져오기 테스트 끝 ====================================");
	}


	

}
