package com.admin.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.service.OrderService;

@SpringBootTest
class InsertTrackingNumTests {

	@Autowired
	OrderService os;

	@Test
	void contextLoads() {
		System.out.println("-------- 송장번호 입력 및 수정 테스트 시작 ---------");


		String trackingNum = "231241577521";
		int orderKey = 4634;
		System.out.println("주문번호: "+orderKey);
		System.out.println("수정 및 입력할 송장번호: "+trackingNum);

		int result = os.insertTrackingNum(trackingNum, orderKey);

		if(result == 1) System.out.println("송장번호 수정 및 입력 성공");
		else System.out.println("송장번호 수정 및 입력 실패");


		System.out.println("-------- 송장번호 입력 및 수정 테스트 끝 ---------");
	}

}
