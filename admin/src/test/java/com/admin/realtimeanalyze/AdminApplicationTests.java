package com.admin.realtimeanalyze;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminApplicationTests {

	@Test
	void contextLoads() {

		LocalDateTime now = LocalDateTime.now();

		// 현재날짜 nowDate
		String nowDate = now.toString().substring(0,10);
		System.out.println(nowDate);

		// 현재시간 nowTime
		String nowTime = now.toString().substring(11,13);
		System.out.println(nowTime);


	}

}
