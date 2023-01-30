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
		System.out.println("-------- 선택 X: 나이대별 판매량 조회 테스트 시작 ---------");

		List<OrderDTO> result = null;

		int categoryKey = -1;
		String gender = "noGender";
		String gender1 = "1";
		String gender2 = "2";
		String startDate = "2022-12-25";
		String endDate = "2022-12-26";

		result = as.ageRangeSales(categoryKey, gender, gender1, gender2, startDate, endDate);
		for (OrderDTO i : result) {
			System.out.println(i);
		}

		System.out.println("-------- 선택 X:나이대별 판매량조회 조회 테스트 끝 ---------");

		System.out.println("-------- 한식, 남자 나이대별 판매량 조회 테스트 시작 ---------");

		result = null;

		categoryKey = 1;
		gender = "1,3";
		gender1 = "1";
		gender2 = "3";
		startDate = "2022-12-25";
		endDate = "2022-12-26";

		result = as.ageRangeSales(categoryKey, gender, gender1, gender2, startDate, endDate);
		for (OrderDTO i : result) {
			System.out.println(i);
			System.out.println(i.getAgeRange());
		}

		System.out.println("-------- 한식,남자 선택 X:나이대별 판매량조회 조회 테스트 끝 ---------");
	}

}
