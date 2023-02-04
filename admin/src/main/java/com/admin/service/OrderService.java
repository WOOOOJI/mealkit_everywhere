package com.admin.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Criteria;
import com.admin.dto.CustomerDTO;
import com.admin.dto.ItemDTO;
import com.admin.dto.OrderDTO;
import com.admin.dto.PageDTO;
import com.admin.dto.response.ItemPageResponseDTO;
import com.admin.frame.MyService;
import com.admin.mapper.OrderMapper;

@Service
public class OrderService implements MyService<Integer, OrderDTO> {

	@Autowired
	OrderMapper orderMapper;

	@Override
	public void register(OrderDTO v) throws Exception {

	}

	@Override
	public void remove(Integer k) throws Exception {

	}

	@Override
	public void modify(OrderDTO v) throws Exception {
	}

	@Override
	public OrderDTO get(Integer k) throws Exception {
		return orderMapper.select(k);
	}

	@Override
	public List<OrderDTO> get() throws Exception {
		return orderMapper.selectall();
	}



	// Get notice orderList
	// 페이징 처리를 위해서 설정한 개수만큼의 주문 페이지 리스트 가져오기
	public List<OrderDTO> getOrderList(Criteria cri){
		try {
			return orderMapper.getOrderList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			// 실패시 null값 전송. view에서 처리할 if문으로 처리할 예정
			return null;
		}
	}




	// Set PageDTO
	// 주문리스트 페이징에 필요한 데이터 가져오기
	public ItemPageResponseDTO getOrderPageMaker(Criteria cri) {

		// 페이징 관련 변수 데이터를 저장할 객체
		PageDTO pageMaker = null;
		int active = 0;
		List<Integer> pageNumList = new ArrayList<>();

		try {
			pageMaker = new PageDTO(cri, orderMapper.countOrder(cri));

			for (int i = pageMaker.getPageStart(); i <= pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * if(pageMaker.getCri().getPageNum() == i) { active = 1; }else { active = 0; }
		 */

		ItemPageResponseDTO itemPageResponseDTO = ItemPageResponseDTO.builder().pageMaker(pageMaker).active(active)
				.pageNumList(pageNumList).build();


		return itemPageResponseDTO;

	}




	// Get order pages (cnt)
	// 주문 페이지 전체 개수 가져오기
	public int countNotice(Criteria cri) throws Exception{
		return orderMapper.countOrder(cri);
	}



	// Change status of totalOrder
	// 주문 상태 변경
	public int statusChange(String status, int orderKey) {
		int result = 0;

		try {
			result = orderMapper.statusChange(status, orderKey);
		}catch(Exception e) {
			System.out.println("Error Caused by at OrderService row 113 line");
			e.printStackTrace();
		}

		return result;
	}


	// Get orderDetail info
	// 주문명세서에 해당되는 주문아이템의 상세 정보 가져오기
	public List<ItemDTO> getOrderDetail(int orderKey) {
		List<ItemDTO> dto = null;

		try {
			dto = orderMapper.getOrderDetail(orderKey);
		} catch (Exception e) {
			System.out.println("Error Caused by at OrderService row 126 line");
			e.printStackTrace();
		}

		return dto;
	}



	// Get customer info
	// 구매한 회원의 정보 가져오기
	public CustomerDTO getCustInfo(int orderKey) {
		CustomerDTO dto = null;

		try {
			dto = orderMapper.getCustInfo(orderKey);

		}catch(Exception e) {
			System.out.println("Error Caused by at OrderService row 147 line");
			e.printStackTrace();
		}

		return dto;
	}


	// Get Address info
	// 주문을 받는 분의 정보 가져오기
	public OrderDTO getToWho(int orderKey) {
		OrderDTO dto = null;

		try {
			dto = orderMapper.getToWho(orderKey);
		}catch(Exception e) {
			System.out.println("Error Caused by at OrderService row 164 line");
			e.printStackTrace();
		}

		return dto;
	}

	// Setting trackingNum
	// 운송장 번호 데이터 수정 및 삽입
	public int insertTrackingNum(String trackingNum, int orderKey) {
		int result = 0;
		try {
			result= orderMapper.insertTrackingNum(trackingNum, orderKey);
		}catch(Exception e) {
			System.out.println("Error Caused by at OrderService row 173 line");
			e.printStackTrace();
		}
		return result;
	}


	// 연도별 TOP10, BOT10, 매출 차트데이터 ======================================
	// 연도별 TOP10 리스트
	public List<OrderDTO> getYearTOP10List(String year){

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String nowDate = sdf.format(date);
		if(year == null) {
			year = nowDate;		
		}

		try {
			return orderMapper.getYearTOP10List(year);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 연도별 BOT10 리스트
	public List<OrderDTO> getYearBOT10List(String year){

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String nowDate = sdf.format(date);
		if(year == null) {
			year = nowDate;		
		}

		try {
			return orderMapper.getYearBOT10List(year);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 월별 TOP10, BOT10, 매출 차트데이터 ======================================
	// 월별 TOP10 리스트
	public List<OrderDTO> getMonthTOP10List(String year, String month){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String nowDate = sdf.format(date);
		String[] dateArr = nowDate.split("-");
		
		
		if(year == null && month == null) {
			year = dateArr[0];
			month = dateArr[1];
		}

		try {
			return orderMapper.getMonthTOP10List(month);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 월별 BOT10 리스트
	public List<OrderDTO> getMonthBOT10List(String year, String month){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String nowDate = sdf.format(date);
		String[] dateArr = nowDate.split("-");
		
		
		if(year == null && month == null) {
			year = dateArr[0];
			month = dateArr[1];
		}

		try {
			return orderMapper.getMonthBOT10List(month);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 일별 TOP10, BOT10, 매출 차트데이터 ======================================
	// 일별 TOP10 리스트

	public List<OrderDTO> getDayTOP10List(String year, String month, String day){
		Date datee = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = sdf.format(datee);
		String[] dateArrr = nowDate.split("-");
		
		
		if(day == null) {
			year = dateArrr[0];
			month = dateArrr[1];
			day = dateArrr[2];
		}

		try {
			return orderMapper.getDayTOP10List(day);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 일별 BOT10 리스트
	public List<OrderDTO> getDayBOT10List(String year, String month, String day){
		Date datee = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = sdf.format(datee);
		String[] dateArrr = nowDate.split("-");
		
		
		if(day == null) {
			year = dateArrr[0];
			month = dateArrr[1];
			day = dateArrr[2];
		}

		try {
			return orderMapper.getDayBOT10List(day);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
