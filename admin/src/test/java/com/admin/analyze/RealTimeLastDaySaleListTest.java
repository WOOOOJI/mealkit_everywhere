package com.admin.analyze;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.FilterdDTO;
import com.admin.dto.OrderDTO;
import com.admin.service.RealTimeAnalyzeService;

@SpringBootTest
class RealTimeLastDaySaleListTest {

	@Autowired
	RealTimeAnalyzeService RealTimeAnalyzeService;

	@Test
	void contextLoads() {
		
		List<OrderDTO> orderDTOList = new ArrayList<>();
		
		orderDTOList = RealTimeAnalyzeService.lastDayChart();
		
		
		for(OrderDTO odto : orderDTOList) {
			System.out.println(odto);
		}
		System.out.println(orderDTOList.toString());
		
		
	}

}
