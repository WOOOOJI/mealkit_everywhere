package com.admin.analyze;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admin.dto.OrderDTO;
import com.admin.mapper.AnalyzeMapper;
import com.admin.service.AnalyzeService;

@SpringBootTest
class DashBoardCardTests {

	@Autowired
	AnalyzeService service;

	@Autowired
	AnalyzeMapper mapper;
	@Test
	@SuppressWarnings("unused")
	void contextLoads() {
		
		
		// 현재날짜, 시간
	    LocalDateTime NOW = LocalDateTime.now();

	    // 현재년도 nowYear
	    String NOWYEAR = NOW.toString().substring(0,4);

	    // 현재월 nowMonth
	    String NOWMONTH = NOW.toString().substring(5,7);

	    // 현재일 nowDay
	    String NOWDAY = NOW.toString().substring(8,10);

	    // 현재날짜 nowDate
	     String NOWDATE = NOW.toString().substring(0,10);

	    // 현재시간 nowTime
	     String NOWTIME = NOW.toString().substring(11,13);
	    
	     System.out.println(NOWDATE);
	    
	  
		// 년도를 보낼시 저장될 통계 데이터를 담을 객체
		OrderDTO thisY = null;
		OrderDTO lastY = null;
		OrderDTO thisM = null;
		OrderDTO lastM = null;
		OrderDTO thisD = null;
		OrderDTO lastD = null;
		String year = "2023";
		String month = "02";
		String day = "11";


		
        service.dashBoardCardYear(year);


		// 년도별 통계로 조회시
		if(month == null && day == null) {
			int lastYear = Integer.parseInt(year)-1;


			try {
				thisY = mapper.dashBoardCardYear(year);
				lastY = mapper.dashBoardCardYear(String.valueOf(lastYear));
			}catch(Exception e){
				e.printStackTrace();
			}



			System.out.println();System.out.println();System.out.println();System.out.println();



			System.out.println("------------올해년도의 데이터-------------");
			System.out.println(thisY);
			System.out.println("총 매출액: "+thisY.getPrice());
			System.out.println("총 배송량: "+thisY.getItemCnt());
			System.out.println("구매확정 제품 수: "+thisY.getStatus());
			System.out.println("환불된 제품 수: "+thisY.getRefund());
			System.out.println("-------------------------------------");
			
			
			double tempCnt = (thisY.getTotalSales() - lastY.getTotalSales()) / (float)lastY.getTotalSales() * 100 *100/100.0;
			if( tempCnt == -1.0) tempCnt = 0.0;
			String tempCntS = String.format("%.2f", tempCnt);
			System.out.println(tempCntS);
			
			
			System.out.println(thisY.getItemCnt());
			System.out.println(lastY.getItemCnt());
			double tempShip = (thisY.getItemCnt() - lastY.getItemCnt()) / (float)lastY.getItemCnt() * 100/100.0;
			
			if(lastY.getItemCnt()==0) tempShip = 100.00;
			
			System.out.println(tempShip);
			if(tempShip == -1.0) tempShip = 0.0;
			String tempShipS = String.format("%.2f", tempShip);
			System.out.println(tempShipS);

			System.out.println();System.out.println();System.out.println();System.out.println();



			System.out.println("--------------작년의 데이터------------------");
			System.out.println(lastY);
			System.out.println("총 매출액: "+lastY.getPrice());
			System.out.println("총 배송량: "+lastY.getItemCnt());
			System.out.println("구매확정 제품 수: "+lastY.getStatus());
			System.out.println("환불된 제품 수: "+lastY.getRefund());
			System.out.println("------------------------------------------");


			System.out.println(); System.out.println(); System.out.println(); System.out.println();
		}


		// 월별 통계로 조회시
		if(month != null && day == null) {

			int lastMonth = Integer.parseInt(month)-1;

			try {
				thisM = mapper.dashBoardCardMonth(year, month);


				if(lastMonth < 10) {
					if(lastMonth == 0) {
						lastMonth = 12;
						year = String.valueOf(Integer.parseInt(year)-1);
						lastM = mapper.dashBoardCardMonth(year, String.valueOf(lastMonth));
					}else {
						lastM = mapper.dashBoardCardMonth(year, "0"+String.valueOf(lastMonth));
					}
				}else {
					lastM = mapper.dashBoardCardMonth(year, String.valueOf(lastMonth));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}



			System.out.println();System.out.println();System.out.println();System.out.println();


			if(thisM != null && lastM != null) {
				System.out.println("------------이번달의 데이터-------------");
				System.out.println(thisM);
				System.out.println("총 매출액: "+thisM.getPrice());
				System.out.println("총 배송량: "+thisM.getItemCnt());
				System.out.println("구매확정 제품 수: "+thisM.getStatus());
				System.out.println("환불된 제품 수: "+thisM.getRefund());
				System.out.println("-------------------------------------");


				System.out.println();System.out.println();System.out.println();System.out.println();



				System.out.println("--------------저번달의 데이터------------------");
				System.out.println(lastM);
				System.out.println("총 매출액: "+lastM.getPrice());
				System.out.println("총 배송량: "+lastM.getItemCnt());
				System.out.println("구매확정 제품 수: "+lastM.getStatus());
				System.out.println("환불된 제품 수: "+lastM.getRefund());
				System.out.println("------------------------------------------");


				System.out.println(); System.out.println(); System.out.println(); System.out.println();

			}
		}


		// 일별 통계로 조회시
		if(month != null && day != null) {

			int lastDay = Integer.parseInt(day)-1;


			try {
				thisD = mapper.dashBoardCardDay(year, month, day);

				if(lastDay < 10) {
					if(lastDay == 0) {
						String dateStr = year+"-"+month+"-"+day+" 00:00:00";
						SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date = null;


							date = transFormat.parse(dateStr);

							Calendar cal = Calendar.getInstance();
							cal.setTime(date);
							cal.add(Calendar.DATE, -1);

							String lastDate = transFormat.format(new Date(cal.getTimeInMillis()));

							System.out.println("받은시간:"+ date);
							System.out.println("연산시간:"+ lastDate);

							String[] dateArr = lastDate.split("-");
							System.out.println("년도: "+dateArr[0]+" 월: "+dateArr[1]+" 일: "+dateArr[2].substring(0,2));

							year = dateArr[0];
							month = dateArr[1];
							day = dateArr[2].substring(0,2);


						year = String.valueOf(Integer.parseInt(year)-1);
						lastD = mapper.dashBoardCardDay(year, month, String.valueOf(lastDay));
					}else {
						lastD = mapper.dashBoardCardDay(year, month, "0"+String.valueOf(lastDay));
					}
				}else {
					lastD = mapper.dashBoardCardDay(year, month, String.valueOf(lastDay));
				}


			}catch(Exception e) {
				e.printStackTrace();
			}

			System.out.println();System.out.println();System.out.println();System.out.println();

			
			

			if(thisD != null && lastD != null) {
				System.out.println("------------선택한 오늘 데이터-------------");
				System.out.println(thisD);
				System.out.println("총 매출액: "+thisD.getPrice());
				System.out.println("총 배송량: "+thisD.getItemCnt());
				System.out.println("구매확정 주문건: "+thisD.getStatus());
				System.out.println("환불된 주문건: "+thisD.getRefund());
				System.out.println("-------------------------------------");


				System.out.println();System.out.println();System.out.println();System.out.println();



				System.out.println("--------------선택한 오늘의 전날 데이터------------------");
				System.out.println(lastD);
				System.out.println("총 매출액: "+lastD.getPrice());
				System.out.println("총 배송량: "+lastD.getItemCnt());
				System.out.println("구매확정 주문건: "+lastD.getStatus());
				System.out.println("환불된 주문건: "+lastD.getRefund());
				System.out.println("------------------------------------------");


				int thisNotRefund = Integer.parseInt(thisD.getStatus());
				int thisRefund = Integer.parseInt(thisD.getRefund());
				int lastNotRefund = Integer.parseInt(lastD.getStatus());
				int lastRefund = Integer.parseInt(lastD.getRefund());

				
				System.out.println(thisNotRefund);
				System.out.println(thisRefund);
				System.out.println(lastNotRefund);
				System.out.println(lastRefund);
				


				System.out.println(); System.out.println(); System.out.println(); System.out.println();



				System.out.println("--------------전날과 비교 데이터------------------");

				System.out.print("오늘과 어제 판매액 증가율: ");
				System.out.println(Math.round((thisD.getPrice() - lastD.getPrice()) / (float)lastD.getPrice() * 100)*100/100.0);

				System.out.print("오늘과 어제 배송량 증가율: ");
				System.out.println(Math.round((thisD.getItemCnt() - lastD.getItemCnt()) / (float)lastD.getItemCnt() * 100)*100/100.0);

				System.out.print("오늘 구매확정율: ");
				System.out.println(Math.round((thisNotRefund/(double)(thisNotRefund+thisRefund)*100)*100)/100.0);
				System.out.print("어제 구매확정율: ");
				System.out.println(Math.round((lastNotRefund/(double)(lastNotRefund+lastRefund)*100)*100)/100.0);

				System.out.print("오늘과 어제 구매확정 증가율: ");
				System.out.println(Math.round((thisNotRefund/(double)(thisNotRefund+thisRefund)*100)*100)/100.0 - Math.round((lastNotRefund/(double)(lastNotRefund+lastRefund)*100)*100)/100.0);

				System.out.println(); System.out.println(); System.out.println(); System.out.println();

			}
		}




	}

}
