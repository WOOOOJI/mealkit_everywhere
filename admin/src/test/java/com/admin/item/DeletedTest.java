package com.admin.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.ItemDTO;
import com.admin.service.ItemService;


@SpringBootTest
class DeletedTest {

	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		System.out.println("item 삭제처리 테스트 시작---------------------------------------------------");

		int itemKey=1;
		service.deleted(itemKey);
		

		System.out.println("item 삭제처리 테스트 끝---------------------------------------------------");
	}

}
