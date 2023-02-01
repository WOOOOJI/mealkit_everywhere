package com.admin.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.OrderAVG;
import com.admin.dto.OrderDTO;
import com.admin.mapper.RealTimeAnalyzeMapper;

@Service
public class RealTimeAnalyzeService {
	
	@Autowired
	RealTimeAnalyzeMapper mapper;
	
	// 현재날짜, 시간
    final static LocalDateTime NOW = LocalDateTime.now();

    // 현재날짜 nowDate
    final static String NOWDATE = NOW.toString().substring(0,10);

    // 현재시간 nowTime
    final static String NOWTIME = NOW.toString().substring(11,13);
    
    public List<OrderDTO> realTimeSalesChart(){
    	List<OrderDTO> result=null;
    	try {
			result=mapper.realTimeSalesChart(NOWDATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    }
    
    public List<OrderDTO> realTimeAgeRangeSales(){
    	List<OrderDTO> result=null;
    	try {
			result=mapper.realTimeAgeRangeSales(NOWDATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    }
    
    public List<OrderDTO> realTimeGenderSales(){
    	List<OrderDTO> result=null;
    	try {
			result=mapper.realTimeGenderSales(NOWDATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    }
    
    public OrderAVG realTimeOrderAvg() {
    	OrderAVG result=new OrderAVG();
    	OrderDTO realtime=null;
    	OrderDTO stacked=null;
    	
    	try {
			realtime=mapper.realTimeOrderAvg(NOWDATE, NOWTIME);
			stacked=mapper.stackedOrderAvg(NOWDATE);		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	result.setRealtimeCnt(realtime.getAvgCnt());
    	result.setRealtimePrice(realtime.getAvgPrice());
    	result.setStackedCnt(stacked.getAvgCnt());
    	result.setStackedPrice(stacked.getAvgPrice());
    	return result;
    }
}