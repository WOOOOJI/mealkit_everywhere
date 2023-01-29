package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.ItemDTO;
import com.admin.dto.OrderDTO;
import com.admin.mapper.AnalyzeMapper;

@Service
public class AnalyzeService {

	@Autowired
	AnalyzeMapper mapper;

	public List<ItemDTO> categoryYearAnalyze(String year) {
		List<ItemDTO> result = null;
		try {
			result = mapper.categoryYearAnalyze(year);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<ItemDTO> categoryMonthAnalyze(String year, String month) {
		List<ItemDTO> result = null;
		try {
			result = mapper.categoryMonthAnalyze(year, month);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<ItemDTO> categoryDayAnalyze(String year, String month, String day) {
		List<ItemDTO> result = null;
		try {
			result = mapper.categoryDayAnalyze(year, month, day);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 특정 년도의 매출차트 데이터 가져오기(월 별)
	public List<OrderDTO> yearSalesChart(String year){
		List<OrderDTO> result = null;
		try {
			result=mapper.yearSalesChart(year);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(OrderDTO o:result) {
			
		}
		return result;
	}

	// 특정 년도의 매출차트 데이터 가져오기(월 별)
	public List<OrderDTO> monthSalesChart(String year, String month){
		List<OrderDTO> result = null;
		try {
			result=mapper.monthSalesChart(year,month);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 특정 년도의 매출차트 데이터 가져오기(월 별)
	public List<OrderDTO> daySalesChart(String year, String month, String day){
		List<OrderDTO> result = null;
		try {
			result=mapper.daySalesChart(year,month,day);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
