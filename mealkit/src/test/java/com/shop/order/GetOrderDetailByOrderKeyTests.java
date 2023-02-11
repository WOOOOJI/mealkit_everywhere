package com.shop.order;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.OrderDetailDTO;
import com.shop.service.OrderDetailService;

@SpringBootTest
class GetOrderDetailByOrderKeyTests {
	@Autowired
	OrderDetailService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 장바구니의 상품들 가져오기 테스트 시작 ====================================");
		List<OrderDetailDTO> result=null;
		int orderKey = 1201;
		result=service.getOrderDetailByOrderkey(orderKey);
		for(OrderDetailDTO o:result) {
			System.out.println(o);
		}
		System.out.println("================================== 장바구니의 상품들 가져오기 테스트 끝 ====================================");
	}


	

}
