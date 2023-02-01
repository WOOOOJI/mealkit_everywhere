package com.admin.realtimeanalyze;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.DashBoardDTO;
import com.admin.service.RealTimeAnalyzeService;

@SpringBootTest
class RealTimeDashBoardTests {

	@Autowired
	RealTimeAnalyzeService service;
	
	@Test
	void contextLoads() {
		System.out.println("-------------------- 실시간 대쉬보드 현황 가져오기 테스트 시작 -----------------------");
		
		LocalDateTime now = LocalDateTime.now();
		
		// 현재날짜 nowDate
		String NOWDATE = now.toString().substring(0,10);
		System.out.println(NOWDATE);
		
		// 현재시간 nowTime
		String NOWTIME = now.toString().substring(11,13);
		System.out.println(NOWTIME);
		
		// 현시간매출
		DashBoardDTO nowDash = new DashBoardDTO();
		// 오늘누적 매출
		DashBoardDTO totalDash = new DashBoardDTO();
		
		
		
		 nowDash = service.realTimeDashBoard(NOWDATE, NOWTIME);
		 
		 // 현시간
		 System.out.println("현시간 매출");
		 System.out.println(nowDash);
		 
		 
		 totalDash = service.totalTimeDashBoard(NOWDATE);
		 
		 // 누적
		 System.out.println("누적 매출");
		 System.out.println(totalDash);
		 
		 System.out.println("-------------------- 실시간 대쉬보드 현황 가져오기 테스트 종료 -----------------------");
		
	}

}
