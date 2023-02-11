package com.shop.order;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.AddressDTO;
import com.shop.service.AddressService;

@SpringBootTest
class UserAddrTests {
	@Autowired
	AddressService service;
	
	
	
	@Test
	void contextLoads() {
		System.out.println("================================== 사용자의 배송지 가져오기 테스트 시작 ====================================");
		List<AddressDTO> list = null;
		int custKey = 4;
		list=service.userAddr(custKey);
		for(AddressDTO o:list) {
			System.out.println(o);
		}
		System.out.println("================================== 사용자의 배송지 가져오기 테스트 끝 ====================================");
	}


	

}
