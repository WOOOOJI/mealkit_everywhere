package com.admin.analyze;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.ItemDTO;
import com.admin.service.AnalyzeService;

@SpringBootTest
class CategoryYearAnalyzeTest {


	@Autowired
	AnalyzeService as;

	@Test
	void contextLoads() {
		System.out.println("-------- 연간 카테고리 판매액,판매량 조회 테스트 시작 ---------");


		List<ItemDTO> result=null;
		String year="2022";
		result=as.categoryYearAnalyze(year);

		for(ItemDTO i:result) {
			System.out.println(i);
		}

		System.out.println("-------- 연간 카테고리 판매액,판매량 조회 테스트 끝 ---------");
	}

}
