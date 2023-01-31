package com.admin.service;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.DashBoardDTO;
import com.admin.dto.ItemDTO;
import com.admin.dto.OrderDTO;
import com.admin.mapper.AnalyzeMapper;

@Service
public class AnalyzeService {

	@Autowired
	AnalyzeMapper mapper;

	public List<ItemDTO> categoryYearAnalyze(String year) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String nowDate = sdf.format(date); 
		if(year == null) {
			year = nowDate;		
		}
		List<ItemDTO> result = null;
		try {
			result = mapper.categoryYearAnalyze(year);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<ItemDTO> categoryMonthAnalyze(String year, String month) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String nowDate = sdf.format(date);
		String[] dateArr = nowDate.split("-");
		
		
		if(year == null && month == null) {
			year = dateArr[0];
			month = dateArr[1];
		}
		List<ItemDTO> result = null;
		try {
			result = mapper.categoryMonthAnalyze(year, month);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<ItemDTO> categoryDayAnalyze(String year, String month, String day) {
		Date datee = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = sdf.format(datee);
		String[] dateArrr = nowDate.split("-");
		
		
		if(day == null) {
			year = dateArrr[0];
			month = dateArrr[1];
			day = dateArrr[2];
		}
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
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String nowDate = sdf.format(date);
		if(year == null) {
			year = nowDate;		
		}
		List<OrderDTO> result = null;
		try {
			result=mapper.yearSalesChart(year);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 특정 년도의 매출차트 데이터 가져오기(월 별)
	public List<OrderDTO> monthSalesChart(String year, String month){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String nowDate = sdf.format(date);
		String[] dateArr = nowDate.split("-");
		
		
		if(year == null && month == null) {
			year = dateArr[0];
			month = dateArr[1];
		}
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
		Date datee = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = sdf.format(datee);
		String[] dateArrr = nowDate.split("-");
		
		
		if(day == null) {
			year = dateArrr[0];
			month = dateArrr[1];
			day = dateArrr[2];
		}
		List<OrderDTO> result = null;
		try {
			result=mapper.daySalesChart(year,month,day);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	// 년도별 대쉬보드 현황
		public DashBoardDTO dashBoardCardYear(String year) {
			DashBoardDTO dash = new DashBoardDTO();
			OrderDTO thisY = null;
			OrderDTO lastY = null;
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String nowDate = sdf.format(date); 
			int lastYear = 0;
			
			if(year == null) {
				year = nowDate;
				lastYear = Integer.parseInt(year)-1;			
			}else {
				lastYear = Integer.parseInt(year)-1;
			}
			
			
			try {
				thisY = mapper.dashBoardCardYear(year);
				lastY = mapper.dashBoardCardYear(String.valueOf(lastYear));				
			}catch(Exception e){
				e.printStackTrace();
			}		
			
			int thisNotRefund = Integer.parseInt(thisY.getStatus());
			int thisRefund = Integer.parseInt(thisY.getRefund());
			int lastNotRefund = Integer.parseInt(lastY.getStatus());
			int lastRefund = Integer.parseInt(lastY.getRefund());
				
			//올해 총 매출액
			dash.setTotalPrice(thisY.getPrice());
			
			//올해 총 판매개수
			dash.setTotalItemCnt(thisY.getTotalSales());
			
			//올해 총 배송량
			dash.setTotalShip(thisY.getItemCnt());
			
			//올해 구매확정율
			dash.setConfirmation(Math.round((thisNotRefund/(double)(thisNotRefund+thisRefund)*100)*100)/100.0);
			
			//올해와 작년 판매액 증가율
			double tempSell = Math.round((thisY.getPrice() - lastY.getPrice()) / (float)lastY.getPrice() * 100)*100/100.0;
			if( tempSell == -1.0) tempSell = 0.0;
			String tempSellS = String.format("%.2f", tempSell);
			dash.setSellIncrease(tempSellS);
			
			//올해와 작년 판매개수 증가율
			double tempCnt = Math.round((thisY.getTotalSales() - lastY.getTotalSales()) / (float)lastY.getTotalSales() * 100)*100/100.0;
			if( tempCnt == -1.0) tempCnt = 0.0;
			String tempCntS = String.format("%.2f", tempCnt);
			dash.setItemCntIncrease(tempCntS);
			
			//올해와 작년 배송량 증가율
			double tempShip = Math.round((thisY.getItemCnt() - lastY.getItemCnt()) / (float)lastY.getItemCnt() * 100)*100/100.0;
			if(tempShip == -1.0) tempShip = 0.0;
			String tempShipS = String.format("%.2f", tempShip);
			dash.setShipIncrease(tempShipS);
			
			//올해와 작년 구매확정 증가율
			double tempConfirm = Math.round((thisNotRefund/(double)(thisNotRefund+thisRefund)*100)*100)/100.0 - Math.round((lastNotRefund/(double)(lastNotRefund+lastRefund)*100)*100)/100.0;
			if(tempConfirm == -1.0) tempConfirm = 0.0;
			String tempConfirmS = String.format("%.2f", tempConfirm);
			dash.setConfirmationIncrease(tempConfirmS);

			dash.setNowYear(year);

			
			return dash;
		}
		
		
		// 월별 대쉬보드 현황
		public DashBoardDTO dashBoardCardMonth(String year, String month) {
			DashBoardDTO dash = new DashBoardDTO();
			OrderDTO thisM = null;
			OrderDTO lastM = null;
			String lastYear = null;
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			String nowDate = sdf.format(date);
			String[] dateArr = nowDate.split("-");
			
			
			if(year == null && month == null) {
				year = dateArr[0];
				month = dateArr[1];
			}
			
			
			int lastMonth = Integer.parseInt(month)-1;
			
			
			try {
				thisM = mapper.dashBoardCardMonth(year, month);
				if(lastMonth < 10) {
					if(lastMonth == 0) {
						lastMonth = 12;
						lastYear = String.valueOf(Integer.parseInt(year)-1);
						lastM = mapper.dashBoardCardMonth(lastYear, String.valueOf(lastMonth));
					}else {					
						lastM = mapper.dashBoardCardMonth(lastYear, "0"+String.valueOf(lastMonth));
					}
				}else {
					lastM = mapper.dashBoardCardMonth(lastYear, String.valueOf(lastMonth));
				}				
			}catch(Exception e){
				e.printStackTrace();
			}		
			
			
			
			int thisNotRefund = Integer.parseInt(thisM.getStatus());
			int thisRefund = Integer.parseInt(thisM.getRefund());
			int lastNotRefund = Integer.parseInt(lastM.getStatus());
			int lastRefund = Integer.parseInt(lastM.getRefund());
			
			//이번달 총 매출액
			dash.setTotalPrice(thisM.getPrice());
			
			//올해 총 판매개수
			dash.setTotalItemCnt(thisM.getTotalSales());
			
			//이번달 총 배송량
			dash.setTotalShip(thisM.getItemCnt());
			
			//이번달 구매확정율
			dash.setConfirmation(Math.round((thisNotRefund/(double)(thisNotRefund+thisRefund)*100)*100)/100.0);
			
			//이번달과 저번달 판매액 증가율
			double tempSell = Math.round((thisM.getPrice() - lastM.getPrice()) / (float)lastM.getPrice() * 100)*100/100.0;
			if( tempSell == -1.0) tempSell = 0.0;
			String tempSellS = String.format("%.2f", tempSell);
			dash.setSellIncrease(tempSellS);
			
			//올해와 작년 판매개수 증가율
			double tempCnt = Math.round((thisM.getTotalSales() - lastM.getTotalSales()) / (float)lastM.getTotalSales() * 100)*100/100.0;
			if( tempCnt == -1.0) tempCnt = 0.0;
			String tempCntS = String.format("%.2f", tempCnt);
			dash.setItemCntIncrease(tempCntS);

			
			//이번달과 저번달 배송량 증가율
			double tempShip = Math.round((thisM.getItemCnt() - lastM.getItemCnt()) / (float)lastM.getItemCnt() * 100)*100/100.0;
			if(tempShip == -1.0) tempShip = 0.0;
			String tempShipS = String.format("%.2f", tempShip);
			dash.setShipIncrease(tempShipS);
			
			//이번달과 저번달 구매확정 증가율
			double tempConfirm = Math.round((thisNotRefund/(double)(thisNotRefund+thisRefund)*100)*100)/100.0 - Math.round((lastNotRefund/(double)(lastNotRefund+lastRefund)*100)*100)/100.0;
			if(tempConfirm == -1.0) tempConfirm = 0.0;
			String tempConfirmS = String.format("%.2f", tempConfirm);
			dash.setConfirmationIncrease(tempConfirmS);

			dash.setNowYear(year);
			dash.setNowMonth(month);
			
			
			return dash;
		}
		
		// 일별 대쉬보드 현황.
		public DashBoardDTO dashBoardCardDay(String year, String month, String day) {
			DashBoardDTO dash = new DashBoardDTO();
			OrderDTO thisD = null;
			OrderDTO lastD = null;
			
			
			
			
			Date datee = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String nowDate = sdf.format(datee);
			String[] dateArrr = nowDate.split("-");
			
			
			if(day == null) {
				year = dateArrr[0];
				month = dateArrr[1];
				day = dateArrr[2];
			}
			
			
			int lastDay = Integer.parseInt(day)-1;
			
			
			try {
				thisD = mapper.dashBoardCardDay(year, month, day);
				
				// 만약 날짜가 1일로 시작하게 되면 월~년도를 그에 맞게 수정해야함
				if(lastDay < 10) {
					if(lastDay == 0) {
						
						// 날짜포멧을 설정한다.
						String dateStr = year+"-"+month+"-"+day+" 00:00:00";
						// 동일.
						SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						// 포멧 변경을 위한 DATE 객체 생성
						Date date = null;
							
							// 날자 포멧 변경하기.
							date = transFormat.parse(dateStr);
							
							Calendar cal = Calendar.getInstance();
							cal.setTime(date);
							// 캘린더 객체에 설정한 날짜를 추가해주고 계산을 한다.
							// .DATE '일' 계산임.
							cal.add(Calendar.DATE, -1);
							
							// 다시 날짜를 문자열로 변환
							String lastDate = transFormat.format(new Date(cal.getTimeInMillis()));
							
							// 문자를 -를 기준으로 짤라서 년, 월, 일을 구해서 서버에 전송
							String[] dateArr = lastDate.split("-");
							System.out.println("년도: "+dateArr[0]+" 월: "+dateArr[1]+" 일: "+dateArr[2].substring(0,2));
						
							String lastYear = dateArr[0];
							String lastMonth = dateArr[1];
							lastDay = Integer.parseInt(dateArr[2].substring(0,2)); 
						
						// ex 2023.01.01일때 년,월,일 변경.
						lastD = mapper.dashBoardCardDay(lastYear, lastMonth, String.valueOf(lastDay));
					}else {
						// 일수가 10미만일때 처리
						lastD = mapper.dashBoardCardDay(year, month, "0"+String.valueOf(lastDay));
					}
				}else {
					// 해당사항 없음. 뷰에서 받은 날짜 그대로 전송
					lastD = mapper.dashBoardCardDay(year, month, String.valueOf(lastDay));
				}	
				
			}catch(Exception e){
				e.printStackTrace();
			}		
			
			int thisNotRefund = Integer.parseInt(thisD.getStatus());
			int thisRefund = Integer.parseInt(thisD.getRefund());
			int lastNotRefund = Integer.parseInt(lastD.getStatus());
			int lastRefund = Integer.parseInt(lastD.getRefund());
			
			//오늘 총 매출액
			dash.setTotalPrice(thisD.getPrice());
			
			//오늘 총 배송량
			dash.setTotalShip(thisD.getItemCnt());
			
			//올해 총 판매개수
			dash.setTotalItemCnt(thisD.getTotalSales());
			
			//오늘 구매확정율
			dash.setConfirmation(Math.round((thisNotRefund/(double)(thisNotRefund+thisRefund)*100)*100)/100.0);
			
			//오늘과 어제 판매액 증가율
			double tempSell = Math.round((thisD.getPrice() - lastD.getPrice()) / (float)lastD.getPrice() * 100)*100/100.0;
			if( tempSell == -1.0) tempSell = 0.0;
			String tempSellS = String.format("%.2f", tempSell);
			dash.setSellIncrease(tempSellS);
			
			//올해와 작년 판매개수 증가율
			double tempCnt = Math.round((thisD.getTotalSales() - lastD.getTotalSales()) / (float)lastD.getTotalSales() * 100)*100/100.0;
			if( tempCnt == -1.0) tempCnt = 0.0;
			String tempCntS = String.format("%.2f", tempCnt);
			dash.setItemCntIncrease(tempCntS);
			
			//오늘과 어제 배송량 증가율
			double tempShip = Math.round((thisD.getItemCnt() - lastD.getItemCnt()) / (float)lastD.getItemCnt() * 100)*100/100.0;
			if(tempShip == -1.0) tempShip = 0.0;
			String tempShipS = String.format("%.2f", tempShip);
			dash.setShipIncrease(tempShipS);
			
			//오늘과 어제 구매확정 증가율
			double tempConfirm = Math.round((thisNotRefund/(double)(thisNotRefund+thisRefund)*100)*100)/100.0 - Math.round((lastNotRefund/(double)(lastNotRefund+lastRefund)*100)*100)/100.0;
			if(tempConfirm == -1.0) tempConfirm = 0.0;
			String tempConfirmS = String.format("%.2f", tempConfirm);
			dash.setConfirmationIncrease(tempConfirmS);
			
			dash.setNowYear(year);
			dash.setNowMonth(month);
			dash.setNowDay(day);
			

			return dash;
		}
		
		//나이대별 판매개수 구하기
		public List<OrderDTO> ageRangeSales(int categoryKey, String gender, String gender1, String gender2, String startDate, String endDate){
			List<OrderDTO> result=null;
			try {
				result=mapper.ageRangeSales(categoryKey, gender, gender1, gender2, startDate, endDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		//성별 판매량 구하기
		public List<OrderDTO> genderSales(int categoryKey, String age, String startDate, String endDate){
			List<OrderDTO> result=null;
			try {
				result=mapper.genderSales(categoryKey, age, startDate, endDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
}