package com.admin.order;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.OrderDTO;
import com.admin.service.OrderService;

@SpringBootTest
class Top10Bot10ListTest {

	@Autowired
	OrderService orderService;

	@Test
	void contextLoads() {

		String year = "2022";

		List<OrderDTO> yearTOP10List = new ArrayList<>();
		List<OrderDTO> yearBOT10List = new ArrayList<>();

		yearTOP10List = orderService.getYearTOP10List(year);
		yearBOT10List = orderService.getYearBOT10List(year);

		System.out.println("연도별 BEST10 : " + yearTOP10List);
		System.out.println("연도별 BEST10 : " + yearBOT10List);

		System.out.println("연도별 BEST1 : "+yearTOP10List.get(0).getItemName()+", "
		+yearTOP10List.get(0).getPrice()+", "+yearTOP10List.get(0).getTotCnt()+", "
		+yearTOP10List.get(0).getTotPrice());

		System.out.println("연도별 WORST1 : "+yearBOT10List.get(0).getItemName()+", "
		+yearBOT10List.get(0).getPrice()+", "+yearBOT10List.get(0).getTotCnt()+", "
		+yearBOT10List.get(0).getTotPrice());
	}

}