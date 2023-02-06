package com.shop.chatbot;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.frame.ChatBotUtil;

@SpringBootTest
class CartItemDeleteTests {

	@Test
	void contextLoads() {
		String q = "비밀번호 찾을래";
		String re = null;
		try {
			re = ChatBotUtil.chat(q);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(re);
	}


}
