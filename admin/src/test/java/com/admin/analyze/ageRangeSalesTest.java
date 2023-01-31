package com.admin.analyze;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.OrderDTO;
import com.admin.service.AnalyzeService;

@SpringBootTest
class ageRangeSalesTest {

	@Autowired
	AnalyzeService as;

	@Test
	void contextLoads() {
		System.out.println("-------- 선택 X: 성별 판매량 조회 테스트 시작 ---------");

		List<OrderDTO> result = null;

		int categoryKey = -1;
		String age="noAge";
		String startDate = "2022-12-25";
		String endDate = "2022-12-26";

		result = as.genderSales(categoryKey, age, startDate, endDate);
		for (OrderDTO i : result) {
			System.out.println(i);
		}

		System.out.println("-------- 선택 X:성별 판매량조회 조회 테스트 끝 / 20대,한식 ---------");
		
		age="20";
		categoryKey=1;
		result = as.genderSales(categoryKey, age, startDate, endDate);
		for (OrderDTO i : result) {
			System.out.println(i);
		}
		
		System.out.println("-------- 20대,한식 선택 성별 판매량조회 조회 테스트 끝 ---------");
	}

}
