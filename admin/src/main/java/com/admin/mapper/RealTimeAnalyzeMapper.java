package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.FilterdDTO;
import com.admin.dto.OrderDTO;

@Mapper
@Repository
public interface RealTimeAnalyzeMapper {
	// 특정 년도의 매출차트 데이터 가져오기(월 별)
	public List<OrderDTO> realTimeSalesChart(String NOWDATE) throws Exception;
	
	//나이대별 판매개수 구하기
	public List<OrderDTO> realTimeAgeRangeSales(String NOWDATE) throws Exception;
	
	//성별 판매량 구하기
	public List<OrderDTO> realTimeGenderSales(String NOWDATE) throws Exception;
	
	//누적 주문당 판매액, 판매량 조회
	public OrderDTO stackedOrderAvg(String NOWDATE) throws Exception;
	
	//실시간 주문당 판매액, 판매량 조회
	public OrderDTO realTimeOrderAvg(String NOWDATE, String NOWTIME) throws Exception;

	// 실시간 대쉬보드 현황
	public OrderDTO realTimeDashBoard(String NOWDATE, String NOWTIME) throws Exception;
	// 누적 대쉬보드 현황
	public OrderDTO totalTimeDashBoard(String NOWDATE) throws Exception;

	// 실시간 판매 상품리스트
	public List<FilterdDTO> realTimefilterdData(FilterdDTO filterdDTO) throws Exception;
}