package com.admin.analyze;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.FilterdDTO;
import com.admin.service.RealTimeAnalyzeService;

@SpringBootTest
class RealTimeDataListTest {

	@Autowired
	RealTimeAnalyzeService RealTimeAnalyzeService;

	@Test
	void contextLoads() {

		List<FilterdDTO> filterdDTOList = new ArrayList<>();
		filterdDTOList = RealTimeAnalyzeService.RealTimefilterdData();

		for(FilterdDTO d : filterdDTOList) {
			System.out.println(d.getName().toString());
		}
		System.out.println(filterdDTOList.toString());

	}

}
