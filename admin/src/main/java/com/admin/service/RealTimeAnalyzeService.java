package com.admin.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.DashBoardDTO;
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
    	OrderDTO realtime=new OrderDTO();
    	OrderDTO stacked=new OrderDTO();
    	
    	try {
			realtime=mapper.realTimeOrderAvg(NOWDATE, NOWTIME);
			stacked=mapper.stackedOrderAvg(NOWDATE);		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	if(realtime!=null) {
    		result.setRealtimeCnt(realtime.getAvgCnt());
    		result.setRealtimePrice(realtime.getAvgPrice());
    	}else {
    		result.setRealtimeCnt("0");
    		result.setRealtimePrice("0");
    	}
    	if(stacked!=null) {
    		result.setStackedCnt(stacked.getAvgCnt());
    		result.setStackedPrice(stacked.getAvgPrice());
    	}else {
    		result.setStackedCnt("0");
    		result.setStackedPrice("0");
    	}
    	return result;
    }
    
 // 실시간 대쉬보드 현황
 	public DashBoardDTO realTimeDashBoard() {
 		DashBoardDTO dash = new DashBoardDTO();
 		OrderDTO od = new OrderDTO();
 		
 		
 		
 		try {
 			od = mapper.realTimeDashBoard(NOWDATE, NOWTIME);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		
 		int thisNotRefund = Integer.parseInt(od.getStatus());
 		int thisRefund = Integer.parseInt(od.getRefund());
 		
 		//실시간 매출액
 		dash.setTotalPrice(od.getPrice());
 		
 		//실시간 배송량
 		dash.setTotalShip(od.getItemCnt());
 		
 		//실시간 판매개수
 		dash.setTotalItemCnt(od.getTotalSales());
 		
 		//실시간 구매확정율
 		dash.setConfirmation(Math.round((thisNotRefund/(double)(thisNotRefund+thisRefund)*100)*100)/100.0);
 		
 		System.out.println(dash);
 		
 		
 		return dash;
 	}
 	
 	
 	// 누적 대쉬보드 현황
 	public DashBoardDTO totalTimeDashBoard() {
 		DashBoardDTO dash = new DashBoardDTO();
 		OrderDTO od = new OrderDTO();
 		
 		
 		
 		try {
 			od = mapper.totalTimeDashBoard(NOWDATE);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		
 		int thisNotRefund = Integer.parseInt(od.getStatus());
 		int thisRefund = Integer.parseInt(od.getRefund());
 		
 		
 		//누적 총 매출액
 		dash.setTotalPrice(od.getPrice());
 		
 		//누적 총 배송량
 		dash.setTotalShip(od.getItemCnt());
 		
 		//올해 총 판매개수
 		dash.setTotalItemCnt(od.getTotalSales());
 		
 		//오늘 구매확정율
 		dash.setConfirmation(Math.round((thisNotRefund/(double)(thisNotRefund+thisRefund)*100)*100)/100.0);
 			
 		
 		
 		return dash;
 	}
 	

}