package com.admin.order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.service.OrderService;

@SpringBootTest
class AgeTest {

	@Autowired
	OrderService orderService;

	@Test
	void contextLoads() {

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");



		Date nowDate = new Date();
		String nowDateStr = sdf.format(nowDate);

		int year = Integer.valueOf(nowDateStr.substring(0,4));
		int month = Integer.valueOf(nowDateStr.substring(4,6));
		int day = Integer.valueOf(nowDateStr.substring(6,8));


		Calendar cal1 = Calendar.getInstance();
		cal1.set(year-10,month,day);



		System.out.println(nowDateStr);

	}

}