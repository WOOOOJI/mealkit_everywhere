package com.admin.order;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.FilterdDTO;
import com.admin.service.AnalyzeService;

@SpringBootTest
class filterdDataListTest {

	@Autowired
	AnalyzeService analyzeService;

	@Test
	void contextLoads() {

		FilterdDTO filterdDTO = new FilterdDTO();
		filterdDTO.setStartDate("2022-12-01");
		filterdDTO.setEndDate("2023-01-31");
		filterdDTO.setCategoryKey(1);
		filterdDTO.setAge("20");
		filterdDTO.setGender1("1");
		filterdDTO.setGender2("3");
		filterdDTO.setAlign("totPrice");

		List<FilterdDTO> filterdDTOList = analyzeService.filterdData(filterdDTO);

		for(FilterdDTO d : filterdDTOList) {
			System.out.println(d.getTotPrice());
		}
		System.out.println(filterdDTOList.size());

	}

}