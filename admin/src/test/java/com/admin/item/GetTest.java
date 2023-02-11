package com.admin.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.ItemDTO;
import com.admin.service.ItemService;


@SpringBootTest
class GetTest {

	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		System.out.println("item 정보 가져오기 테스트 시작---------------------------------------------------");
		ItemDTO result=null;
		int itemKey=1;
		result=service.get(itemKey);
		
		System.out.println(result);
		System.out.println("item 정보 가져오기 끝---------------------------------------------------");
	}

}
