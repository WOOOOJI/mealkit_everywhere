package com.admin.analyze;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.OrderDTO;
import com.admin.service.AnalyzeService;

@SpringBootTest
class Test1 {


	@Autowired
	AnalyzeService as;

	@Test
	void contextLoads() {
		
		String monthStr = "02";
		int lastMonth = 0;
		
		lastMonth = Integer.valueOf(monthStr);
		System.out.println(lastMonth);
		
	}

}
