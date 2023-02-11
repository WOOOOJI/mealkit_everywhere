package com.admin.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.DashBoardDTO;
import com.admin.dto.FilterdDTO;
import com.admin.dto.OrderAVG;
import com.admin.dto.OrderDTO;
import com.admin.mapper.RealTimeAnalyzeMapper;

@Service
public class RealTimeAnalyzeService {

	@Autowired
	RealTimeAnalyzeMapper mapper;

    @Autowired
	AnalyzeService analyzeService;

    public Map<String,String> getTime(){
    	HashMap<String, String> result=new HashMap<String,String>();
    	// 현재날짜, 시간
        LocalDateTime now = LocalDateTime.now();

        // 현재년도 nowYear
        String nowYear = now.toString().substring(0,4);

        // 현재월 nowMonth
        String nowMonth = now.toString().substring(5,7);

        // 현재일 nowDay
        String nowDay = now.toString().substring(8,10);

        // 현재날짜 nowDate
        String nowDate = now.toString().substring(0,10);

        // 현재시간 nowTime
        String nowTime = now.toString().substring(11,13);
        
        result.put("nowYear", nowYear);
        result.put("nowMonth", nowMonth);
        result.put("nowDay", nowDay);
        result.put("nowDate", nowDate);
        result.put("nowTime", nowTime);
        
        return result;
    }

    
    
   
    //실시간 차트
    public List<OrderDTO> realTimeSalesChart(){
    	Map<String, String> now=getTime();
    	List<OrderDTO> result=null;
    	try {
			result=mapper.realTimeSalesChart(now.get("nowDate"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    }
    
    //나이대별 판매
    public List<OrderDTO> realTimeAgeRangeSales(){
    	Map<String, String> now=getTime();
    	List<OrderDTO> result=null;
    	try {
			result=mapper.realTimeAgeRangeSales(now.get("nowDate"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    }
    
    //성별 판매
    public List<OrderDTO> realTimeGenderSales(){
    	Map<String, String> now=getTime();
    	List<OrderDTO> result=null;
    	try {
			result=mapper.realTimeGenderSales(now.get("nowDate"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    }
    
    //평균 구매액, 개수
    public OrderAVG realTimeOrderAvg() {
    	OrderAVG result=new OrderAVG();
    	OrderDTO realtime=new OrderDTO();
    	OrderDTO stacked=new OrderDTO();
    	Map<String, String> now=getTime();

    	try {
			realtime=mapper.realTimeOrderAvg(now.get("nowDate"), now.get("nowTime"));
			stacked=mapper.stackedOrderAvg(now.get("nowDate"));
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
    	
    	System.out.println(now.get("nowTime"));
    	return result;
    }
 // 실시간 대쉬보드 현황
 	public DashBoardDTO realTimeDashBoard() {
 		DashBoardDTO dash = new DashBoardDTO();
 		OrderDTO od = new OrderDTO();
 		Map<String, String> now=getTime();
 		
 		try {
 			od = mapper.realTimeDashBoard(now.get("nowDate"), now.get("nowTime"));
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		
 		

 		int thisNotRefund = Integer.parseInt(od.getStatus());
 		int thisRefund = Integer.parseInt(od.getRefund());

 		//실시간 매출액
 		dash.setTotalPrice(String.valueOf(od.getPrice()));

 		//실시간 배송량
 		dash.setTotalShip(String.valueOf(od.getItemCnt()));

 		//실시간 판매개수
 		dash.setTotalItemCnt(String.valueOf(od.getTotalSales()));

 		//실시간 구매확정율
 		dash.setConfirmation(Math.round((thisNotRefund/(double)(thisNotRefund+thisRefund)*100)*100)/100.0);
 		
 		String[] dateArr = new String[4];
 		dateArr[0] = now.get("nowYear");
 		dateArr[1] = now.get("nowMonth");
 		dateArr[2] = now.get("nowDay");
 		dateArr[3] = now.get("nowTime");
 		
 		dash.setArr(dateArr);

 		return dash;
 	}


 	// 누적 대쉬보드 현황
 	public DashBoardDTO totalTimeDashBoard() {
 		DashBoardDTO dash = new DashBoardDTO();
 		OrderDTO od = new OrderDTO();
 		Map<String, String> now=getTime();


 		try {
 			od = mapper.totalTimeDashBoard(now.get("nowDate"));
 		} catch (Exception e) {
 			e.printStackTrace();
 		}

 		int thisNotRefund = Integer.parseInt(od.getStatus());
 		int thisRefund = Integer.parseInt(od.getRefund());


 		//누적 총 매출액
 		dash.setTotalPrice(String.valueOf(od.getPrice()));

 		//누적 총 배송량
 		dash.setTotalShip(String.valueOf(od.getItemCnt()));

 		//올해 총 판매개수
 		dash.setTotalItemCnt(String.valueOf(od.getTotalSales()));

 		//오늘 구매확정율
 		dash.setConfirmation(Math.round((thisNotRefund/(double)(thisNotRefund+thisRefund)*100)*100)/100.0);



 		return dash;
 	}

 	 // 실시간 판매순위 리스트
 		public List<FilterdDTO> RealTimefilterdData(){
 			FilterdDTO filterdDTO = new FilterdDTO();
 			String gender = "noGender";
 			String align = "totPrice";
 			Map<String, String> now=getTime();
 			filterdDTO.setAlign(align);
 			filterdDTO.setGender(gender);
 			filterdDTO.setStartDate(now.get("nowDate"));
 			filterdDTO.setEndDate(now.get("nowDate") + " " + now.get("nowTime"));

 			List<FilterdDTO> filterdDTOList = new ArrayList<>();

 			try {
 				filterdDTOList = mapper.realTimefilterdData(filterdDTO);
 				return filterdDTOList;
 			} catch (Exception e) {
 				e.printStackTrace();
 				return null;
 			}
 		}


 		// 하루전 매출 차트
 		public List<OrderDTO> lastDayChart(){
 			List<OrderDTO> lastDaySalesChart = new ArrayList<>();
 			Map<String, String> now = getTime();
 			lastDaySalesChart = analyzeService.lastDaySalesChart(now.get("nowYear"),now.get("nowMonth"),now.get("nowDay"));
 			return lastDaySalesChart;
 		}

 		
}