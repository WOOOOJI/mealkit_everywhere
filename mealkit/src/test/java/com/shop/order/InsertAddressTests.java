package com.shop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.AddressDTO;
import com.shop.service.AddressService;

@SpringBootTest
class InsertAddressTests {
	@Autowired
	AddressService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 배송지 추가하기 테스트 시작 ====================================");
		int custKey=4;
		AddressDTO address=new AddressDTO();
		address.setAddr("인천광역시");
		address.setAddrDetail("101호");
		address.setName("김테스트");
		address.setTel("01012345678");
		address.setZipcode("21030");
		service.insertAddress(custKey, address);
		System.out.println("================================== 배송지 추가하기 테스트 끝 ====================================");
	}


	

}
