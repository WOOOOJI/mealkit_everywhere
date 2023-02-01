package com.admin.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealTimeAnalyzeController {
	
	@RequestMapping("/getRealTimeData")
	public JSONObject getRealTimeData() {
		JSONObject json = new JSONObject();
		
		return json;
	}
	
}
