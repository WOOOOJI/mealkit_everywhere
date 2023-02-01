package com.admin.realtimeanalyze;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.OrderDTO;
import com.admin.service.RealTimeAnalyzeService;

@SpringBootTest
class RealTimeGenderSalesTest {
	
	
	@Autowired
	RealTimeAnalyzeService as;
	
	@Test
	void contextLoads() {
		System.out.println("-------- 실시간 성별 판매량 조회 테스트 시작 ---------");
		
		List<OrderDTO> result=null;

		result=as.realTimeGenderSales();
		for(OrderDTO i:result) {
			System.out.println(i);
		}
		
		System.out.println("-------- 실시간 성별 판매량 조회 테스트 끝 ---------");
	}

}
