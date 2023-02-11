package com.shop.controller;


import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.dto.CommentsDTO;
import com.shop.service.CommentsService;


@Controller
@RequestMapping("/comments")
public class CommentsController {
	
	@Autowired
	CommentsService commentsService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/adminCmt")
	@ResponseBody
	public Object adminCmtAjax(@RequestBody String commentsJSON, 
								HttpServletResponse response, ModelMap model){
		
		response.setContentType("text/html; charset=UTF-8");
		
		JSONObject obj = new JSONObject();
		
		CommentsDTO cmtDTO = new CommentsDTO();
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			cmtDTO = (CommentsDTO)mapper.readValue(commentsJSON, new TypeReference<CommentsDTO>() {});
			
			cmtDTO = commentsService.getComment(cmtDTO);
		//	System.out.println(cmtDTO.toString());
			
			obj.put("cmtDTO", cmtDTO);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			obj.put("res", "error");
		}
		
		return obj;
	}
		
}
