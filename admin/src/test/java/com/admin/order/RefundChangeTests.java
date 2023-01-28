package com.admin.order;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.Criteria;
import com.admin.dto.CustomerDTO;
import com.admin.dto.ItemDTO;
import com.admin.dto.OrderDTO;
import com.admin.service.OrderService;

@SpringBootTest
class RefundChangeTests {

	@Autowired
	OrderService os;
	
	@Test
	void contextLoads() {
		System.out.println("-------- 주문 환불 승인 테스트 시작 ---------");
		
		int result = 0;
		int orderKey = 4634;
		String status = "F";
		
		System.out.println("환불 승인을 할 주문번호: " + orderKey);
		System.out.println("환불 요청 고유 문자열: " + status);
		
		result = os.statusChange(status, orderKey);
		
		if(result == 1) System.out.println("환불 승인 성공");
		else System.out.println("환불 승인 실패");
		
		System.out.println("-------- 주문 환불 승인 테스트 끝 ---------");
	}

}
