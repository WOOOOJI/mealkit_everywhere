package com.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.mapper.AnalyzeMapper;

@Service
public class AnalyzeSerivce {

	@Autowired
	AnalyzeMapper mapper;
	
	
}
