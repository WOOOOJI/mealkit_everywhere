package com.shop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.AddressDTO;
import com.shop.service.OrderService;

@SpringBootTest
class OrderUpdateTests {
	@Autowired
	OrderService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 주문 UPDATE 테스트 시작 ====================================");
		int orderKey=4643;
		int payment=40000;
		AddressDTO address=new AddressDTO();
		address.setAddr("인천광역시");
		address.setAddrDetail("101호");
		address.setName("김테스트");
		address.setTel("01012345678");
		address.setZipcode("21030");
		service.orderUpdate(address, orderKey, payment);
		System.out.println("================================== 주문 UPDATE 테스트 끝 ====================================");
	}


	

}
