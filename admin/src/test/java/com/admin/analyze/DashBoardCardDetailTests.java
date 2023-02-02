package com.admin.analyze;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.DashBoardDTO;
import com.admin.dto.OrderDTO;
import com.admin.service.AnalyzeService;

@SpringBootTest
class DashBoardCardDetailTests {

	@Autowired
	AnalyzeService as;

	@Test
	void contextLoads() {
		System.out.println("-------- 선택 X: 상세조회 테스트 시작 ---------");

		DashBoardDTO result=null;

		int categoryKey = -1;
		String age="noAge";
		String gender="noGender";
		String gender1="";
		String gender2="";
		String startDate = "2022-12-01";
		String endDate = "2022-12-26";
		

		result=as.dashBoardCardDetail(startDate, endDate, gender, gender1, gender2, age, categoryKey);
		System.out.println(result);
		System.out.println("-------- 선택 X:조회 테스트 끝 ");
		
		categoryKey=1;
		age="20";
		gender="2,4";
		gender1="2";
		gender2="4";

		result=as.dashBoardCardDetail(startDate, endDate, gender,gender1, gender2, age, categoryKey);
		System.out.println(result);
		System.out.println("-------- 30대 한식 남자 조회 테스트 끝 ");
	}

}