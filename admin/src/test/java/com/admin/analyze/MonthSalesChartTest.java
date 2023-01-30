package com.admin.analyze;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.OrderDTO;
import com.admin.service.AnalyzeService;

@SpringBootTest
class MonthSalesChartTest {
	
	
	@Autowired
	AnalyzeService as;
	
	@Test
	void contextLoads() {
		System.out.println("-------- 월간 매출 차트 조회 테스트 시작 ---------");
		
		
		List<OrderDTO> result=null;
		String year="2023";String month="01";
		result=as.monthSalesChart(year,month);
		
		for(OrderDTO i:result) {
			System.out.println(i);
		}
		
		System.out.println("-------- 월간 매출 차트 조회 테스트 끝 ---------");
	}

}
