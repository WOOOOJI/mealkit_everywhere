package com.admin.realtimeanalyze;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.OrderAVG;
import com.admin.service.RealTimeAnalyzeService;

@SpringBootTest
class RealTimeOrderAvgTest {


	@Autowired
	RealTimeAnalyzeService as;

	@Test
	void contextLoads() {
		System.out.println("-------- 실시간 주문당 판매량/판매액 조회 테스트 시작 ---------");

		OrderAVG result=null;

		result=as.realTimeOrderAvg();
		System.out.println(result);

		System.out.println("-------- 실시간 주문당 판매량/판매액 조회 테스트 끝 ---------");
	}

}
