package com.admin.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.admin.dto.Msg;
import com.admin.frame.ChatBotUtil;




@Controller
public class ChatBotController {
	
	@Autowired
	SimpMessagingTemplate template;
	
	@MessageMapping("/chatbotme") // 나에게만 전송 ex)Chatbot
	public void receiveme(Msg msg, SimpMessageHeaderAccessor headerAccessor) throws IOException {
		String id = msg.getSendid();
		msg.setContent2(msg.getContent1());
		String result = ChatBotUtil.chat(msg.getContent1());
		msg.setContent1(result);
		template.convertAndSend("/send/"+id,msg);
	}
	
}
